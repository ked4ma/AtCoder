SHELL := /bin/bash
TARGET := $(firstword $(MAKECMDGOALS))
RUN_ARGS := $(wordlist 2,$(words $(MAKECMDGOALS)),$(MAKECMDGOALS))
# not to handle RUN_ARGS as "make" tasks
$(eval $(RUN_ARGS):;@:)
RUN_ARGS_LEN := $(words $(RUN_ARGS))

# task for checking global vars
check-vars:
	@echo "SHELL: $(SHELL)"
	@echo "TARGET: $(TARGET)"
	@echo "RUN_ARGS: $(RUN_ARGS)"
	@echo "RUN_ARGS_LEN $(RUN_ARGS_LEN)"

init: clean
ifeq ($(shell expr $(RUN_ARGS_LEN) \>= 1), 1)
	$(eval CONTEST_BRANCH=$(word 1, $(RUN_ARGS)))
	$(eval BRANCH=$(shell git branch --show-current))
	@if [ $(BRANCH) = "feature/$(CONTEST_BRANCH)" ]; then \
	  echo "[Info] Already in feature/$(CONTEST_BRANCH) branch"; \
	  if [ ! -d src/main/java/com/github/ked4ma/atcoder/$(CONTEST_BRANCH) ]; then \
	    mkdir -p src/main/java/com/github/ked4ma/atcoder/$(CONTEST_BRANCH); \
	  fi \
	elif [ -d src/main/java/com/github/ked4ma/atcoder/$(CONTEST_BRANCH) ]; then \
	  echo "[Info] $(CONTEST_BRANCH) is already finished."; \
	else \
	  git switch -c feature/$(CONTEST_BRANCH); \
	  mkdir -p src/main/java/com/github/ked4ma/atcoder/$(CONTEST_BRANCH); \
	fi
else
	@echo "[Err] Contest name is Required."
endif

base:
	$(eval CONTEST_BRANCH=$(word 2, $(subst /, , $(shell git branch --show-current))))
	$(eval CONTEST=$(subst _na,, $(CONTEST_BRANCH)))

run-base:
	$(eval QUESTION_FILENAME=$(word 1, $(RUN_ARGS)))
	$(eval QUESTION=$(subst _x,, $(QUESTION_FILENAME)))

run: base run-base
	@source ./secret.conf && \
	  ./gradlew -Pcontest=$(CONTEST_BRANCH) cleanTest \
	    test --tests "com.github.ked4ma.atcoder.TestRunner" -Dtask=$(QUESTION_FILENAME)

#runOnly: run-base
#	./bin/run2.sh $(CONTEST_BRANCH) $(QUESTION_FILENAME) .input/input$(QUESTION).txt

format: base run-base
	@echo "[Info] Format for submiting $(CONTEST)/$(QUESTION)."
	./bin/format.sh $(CONTEST_BRANCH) $(QUESTION_FILENAME)
	@echo "[Info] Copied to Clipboard."

finish: base
	@echo "[Info] Finish $(CONTEST_BRANCH)"
	git commit -a -m "$(CONTEST_BRANCH)"
	git switch main
	git merge --no-ff feature/$(CONTEST_BRANCH)
	git branch -d feature/$(CONTEST_BRANCH)
	git tag $(CONTEST_BRANCH)
	git push origin main --tags

clean:
	./gradlew clean

.PHONY: clean init base run runOnly run-base format finish check-vars

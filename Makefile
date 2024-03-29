SHELL := /bin/bash
TARGET := $(firstword $(MAKECMDGOALS))
RUN_ARGS := $(wordlist 2,$(words $(MAKECMDGOALS)),$(MAKECMDGOALS))
# not to handle RUN_ARGS as "make" tasks
$(eval $(RUN_ARGS):;@:)
RUN_ARGS_LEN := $(words $(RUN_ARGS))

BRANCH=$(shell git branch --show-current)
CONTEST_BRANCH=$(word 2, $(subst /, , $(BRANCH)))
CONTEST=$(subst _na,, $(CONTEST_BRANCH))
TASK_FILENAME=$(word 1, $(RUN_ARGS))
TASK=$(subst _x,, $(TASK_FILENAME))

# task for checking global vars
check-vars:
	@echo SHELL: $(SHELL)
	@echo TARGET: $(TARGET)
	@echo RUN_ARGS: $(RUN_ARGS)
	@echo RUN_ARGS_LEN $(RUN_ARGS_LEN)
	@echo "=========="
	@echo BRANCH $(BRANCH)
	@echo CONTEST_BRANCH $(CONTEST_BRANCH)
	@echo CONTEST $(CONTEST)
	@echo TASK_FILENAME $(TASK_FILENAME)
	@echo TASK $(TASK)
	@echo "=========="

init: clean
ifeq ($(RUN_ARGS_LEN), 1)
	$(eval CONTEST_BRANCH=$(word 1, $(RUN_ARGS)))
	@if [ $(BRANCH) = "contest/$(CONTEST_BRANCH)" ]; then \
	  echo "[Info] Already in contest/$(CONTEST_BRANCH) branch"; \
	  if [ ! -d src/main/kotlin/com/github/ked4ma/atcoder/$(CONTEST_BRANCH) ]; then \
	    mkdir -p src/main/kotlin/com/github/ked4ma/atcoder/$(CONTEST_BRANCH); \
	  fi \
	elif [ -d src/main/kotlin/com/github/ked4ma/atcoder/$(CONTEST_BRANCH) ]; then \
	  echo "[Info] $(CONTEST_BRANCH) is already finished."; \
	else \
	  echo "[Info] preparing for the contest ($(CONTEST))"; \
	  git switch -c contest/$(CONTEST_BRANCH); \
	  mkdir -p src/main/kotlin/com/github/ked4ma/atcoder/$(CONTEST_BRANCH); \
	fi
else
	@echo "[Usage] make init <CONTEST NAME>"
endif

run:
	@source ./secret.conf && \
	  ./gradlew -Pcontest=$(CONTEST_BRANCH) cleanTest \
	    test --tests "com.github.ked4ma.atcoder.TestRunner" -Dtask=$(TASK_FILENAME) -Dbranch=$(BRANCH)

format:
	@echo "[Info] Format for submitting $(CONTEST)/$(TASK)."
	./bin/format.sh $(CONTEST_BRANCH) $(TASK_FILENAME)
	@echo "[Info] Copied to Clipboard."

finish:
	@echo "[Info] Finish $(CONTEST_BRANCH)"
	git commit -a -m "$(CONTEST_BRANCH)"
	git switch main
	git merge --no-ff contest/$(CONTEST_BRANCH)
	git branch -d contest/$(CONTEST_BRANCH)
	git tag $(CONTEST_BRANCH)
	git push origin main --tags

clean:
	./gradlew clean

problems:
	@source ./secret.conf && \
	  ./gradlew -Pproblems=1 cleanTest \
	    test --tests "com.github.ked4ma.atcoder.AtCoderProblemsTestRunner"

problems-format:
	./bin/format-problems.sh
	@echo "[Info] Copied to Clipboard."

test:
	./gradlew test --tests "com.github.ked4ma.atcoder.utils.*"

.PHONY: clean init run format finish check-vars problems problems-format test

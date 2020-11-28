SHELL := /bin/bash
TARGET := $(firstword $(MAKECMDGOALS))
RUN_ARGS := $(wordlist 2,$(words $(MAKECMDGOALS)),$(MAKECMDGOALS))
# ...and turn them into do-nothing targets
$(eval $(RUN_ARGS):;@:)
RUN_ARGS_LEN := $(words $(RUN_ARGS))

init:
	npm ci
ifeq ($(shell expr $(RUN_ARGS_LEN) \>= 1), 1)
	$(eval CONTEST_BRANCH=$(word 1, $(RUN_ARGS)))
	$(eval BRANCH=$(shell git branch --show-current))
	@if [ $(BRANCH) = "feature/$(CONTEST_BRANCH)" ]; then \
	  echo "[Info] Already in feature/$(CONTEST_BRANCH) branch"; \
	  if [ ! -d src/main/java/com/github/khronos227/atcoder/$(CONTEST_BRANCH) ]; then \
	    mkdir -p src/main/java/com/github/khronos227/atcoder/$(CONTEST_BRANCH); \
	  fi \
	elif [ -d src/main/java/com/github/khronos227/atcoder/$(CONTEST_BRANCH) ]; then \
	  echo "[Info] $(CONTEST_BRANCH) is already finished."; \
	else \
	  git switch -c feature/$(CONTEST_BRANCH); \
	  mkdir -p src/main/java/com/github/khronos227/atcoder/$(CONTEST_BRANCH); \
	fi
else
	@echo "[Err] Contest name is Required."
endif

base:
	$(eval CONTEST_BRANCH=$(word 2, $(subst /, , $(shell git branch --show-current))))
	$(eval CONTEST=$(subst _na,, $(CONTEST_BRANCH)))

run-base: base
	$(eval QUESTION_FILENAME=$(word 1, $(RUN_ARGS)))
	$(eval QUESTION=$(subst _x,, $(QUESTION_FILENAME)))

run: run-base
	@echo "[Info] Get input data from the web site."
	@mkdir -p .input
	node bin/inputParser.js $(CONTEST) $(QUESTION) .input/input$(QUESTION).txt
	@echo "[Info] Run $(CONTEST_BRANCH)/$(QUESTION) (input: .input/input$(QUESTION).txt"
	./bin/run2.sh $(CONTEST_BRANCH) $(QUESTION_FILENAME) .input/input$(QUESTION).txt

format: run-base
	@echo "[Info] Format for submiting $(CONTEST)/$(QUESTION)."
	./bin/format.sh $(CONTEST_BRANCH) $(QUESTION_FILENAME)
	@echo "[Info] Copied to Clipboard."

finish: base
	@echo "[Info] Finish $(CONTEST_BRANCH)"
	git commit -a -m "$(CONTEST_BRANCH)"
	git switch master
	git merge --no-ff feature/$(CONTEST_BRANCH)
	git branch -d feature/$(CONTEST_BRANCH)
	git tag $(CONTEST_BRANCH)
	git push origin master --tags

exec-base:
	$(eval CONTEST_BRANCH=$(subst _x, , $(word 1, $(RUN_ARGS))))
	$(eval CONTEST=$(subst _na, , $(CONTEST_BRANCH)))
	$(eval QUESTION_FILENAME=$(word 2, $(RUN_ARGS)))
	$(eval QUESTION=$(subst _x, , $(QUESTION_FILENAME)))

exec: exec-base
	@echo "[Info] Get input data from the web site."
	@mkdir -p .input
	node bin/inputParser.js $(CONTEST) $(QUESTION) .input/input$(QUESTION).txt
	@echo "[Info] Run $(CONTEST_BRANCH)/$(QUESTION) (input: .input/input$(QUESTION).txt"
	./bin/run2.sh $(CONTEST_BRANCH) $(QUESTION_FILENAME) .input/input$(QUESTION).txt

reformat: exec-base
	@echo "[Info] Format for submiting $(CONTEST)/$(QUESTION)."
	./bin/format.sh $(CONTEST_BRANCH) $(QUESTION_FILENAME)
	@echo "[Info] Copied to Clipboard."

sandbox:
	$(eval FILE=$(word 1, $(RUN_ARGS)))
	./gradlew -PmainClass=com.github.khronos227.atcoder.sandbox.$(FILE)Kt -Pcontest=sandbox run

clean:
	./gradlew clean

.PHONY: clean init base run run-base format finish sandbox exec-base exec reformat

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
	$(eval CONTEST=$(subst _na, , $(CONTEST_BRANCH)))

run: base
	@mkdir -p .input
	$(eval QUESTION=$(subst _x, , $(word 1, $(RUN_ARGS))))
	node bin/inputParser.js $(CONTEST) $(QUESTION) .input/input$(QUESTION).txt
	./bin/run2.sh $(CONTEST_BRANCH) $(word 1, $(RUN_ARGS)) .input/input$(QUESTION).txt

finish: base
	git commit -a -m "$(CONTEST_BRANCH)"
	git switch master
	git merge --no-ff feature/$(CONTEST_BRANCH)
	git branch -d feature/$(CONTEST_BRANCH)
	git tag $(CONTEST_BRANCH)
	git push origin master --tags

sandbox:
	$(eval FILE=$(word 1, $(RUN_ARGS)))
	./gradlew -PmainClass=com.github.khronos227.atcoder.sandbox.$(FILE)Kt -Pcontest=sandbox run

clean:
	./gradlew clean

.PHONY: clean init base run finish

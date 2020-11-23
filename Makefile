TARGET := $(firstword $(MAKECMDGOALS))
RUN_ARGS := $(wordlist 2,$(words $(MAKECMDGOALS)),$(MAKECMDGOALS))
# ...and turn them into do-nothing targets
$(eval $(RUN_ARGS):;@:)
RUN_ARGS_LEN := $(words $(RUN_ARGS))

init:
ifeq ($(shell expr $(RUN_ARGS_LEN) \>= 1), 1)
	$(eval CONTEST=$(word 1, $(RUN_ARGS)))
	$(eval BRANCH=$(shell git branch --show-current))
	@if [ $(BRANCH) = "feature/$(CONTEST)" ]; then \
	  echo "[Info] Already in feature/$(CONTEST) branch"; \
	  if [ ! -d src/main/java/com/github/khronos227/atcoder/$(CONTEST) ]; then \
	    mkdir -p src/main/java/com/github/khronos227/atcoder/$(CONTEST); \
	  fi \
	elif [ -d src/main/java/com/github/khronos227/atcoder/$(CONTEST) ]; then \
	  echo "[Info] $(CONTEST) is already finished."; \
	else \
	  git switch -c feature/$(CONTEST); \
	  mkdir -p src/main/java/com/github/khronos227/atcoder/$(CONTEST); \
	fi
else
	@echo "[Err] Contest name is Required."
endif

base:
	$(eval CONTEST=$(word 2, $(subst /, , $(shell git branch --show-current))))
	@echo $(CONTEST)

run: base
	$(eval QUESTION=$(word 1, $(RUN_ARGS)))
	./run2.sh $(CONTEST) $(QUESTION) input$(QUESTION).txt

finish: base
	git commit -a -m "$(CONTEST)"
	git switch master
	git merge --no-ff feature/$(CONTEST)
	git tag $(CONTEST)
	git push origin master --tags

clean:
	./gradlew clean

.PHONY: clean init base run finish

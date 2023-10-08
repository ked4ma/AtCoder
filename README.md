# AtCoder
AtCoder challenge logs

# Usage
In this repo, we use Makefile to run code.

## Init
```bash
make init <CONTEST_ID>
---
$ make init abc123
```
Initialize for the contest.  
NOTE: We need on `main` branch before run `init`.

## Run
```bash
make run <TASK_FILENAME> [CONTEST_BRANCH=<*>]
---
$ make run A
$ make run D_x # you can add suffix like "x" with "_" as a mark
$ make run E CONTEST_BRANCH=abc123 # you can specify tasks of other contests
```

## Format
```bash
make format <TASK_FILENAME> [CONTEST_BRANCH=<*>]
---
$ make format A
$ make format D_x
$ make format E CONTEST_BRANCH=abc123
```

## Finish
```bash
make finish
```
Finish contest.  
This commit uncommited files and merge to `main` branch, and then push `main` and tags.

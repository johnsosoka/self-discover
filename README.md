# self-discover

A Java Spring implementation of the SELF-DISCOVER algorithm. 

Read The Paper: ["SELF-DISCOVER: Large Language Models Self-Compose Reasoning Structures"](https://arxiv.org/pdf/2402.03620.pdf)


## Overview

This is an implementation of the SELF-DISCOVER algorithm proposed in the paper. The algorithm is designed to allow large 
language models to self-compose reasoning structures. The overall process is quite
simple. 

### Composition Phase - Generating a Reasoning Structure

1. **Select:** The LLM is provided a `task` and a list of `reasoning modules` and is asked to select the most appropriate reasoning modules to solve the task.
2. **Adapt:** The LLM is provided the _selected_ `reasoning modules` and the task. It is asked to adapt the selected reasoning modules to the task.
3. **Implement:** 
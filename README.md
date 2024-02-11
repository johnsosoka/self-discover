# SELF-DISCOVER: LLMs Self-Composing Reasoning Structures

A Java Spring implementation of the SELF-DISCOVER algorithm. This algorithm, through multiple passes, allows
for large language models to self-compose reasoning structures for a given task. There is a bank of pre-existing
reasoning modules that the LLM can select from and adapt to the task at hand. 

Read The Paper: ["SELF-DISCOVER: Large Language Models Self-Compose Reasoning Structures"](https://arxiv.org/pdf/2402.03620.pdf)

## Getting Started

1. Clone the repository
2. copy `application.properties.example` to `application.properties` and add your api key.
3. Execute `ReasoningServiceTests` to see the algorithm in action.


## Overview

This is an implementation of the SELF-DISCOVER algorithm proposed in the paper. The algorithm is designed to allow large 
language models to self-compose reasoning structures.

### Composition Phase - Generating a Reasoning Structure


1. **Select:** The LLM is provided a `task` and a list of `reasoning modules` and is asked to select the most appropriate reasoning modules to solve the task.
2. **Adapt:** The LLM is provided the _selected_ `reasoning modules` and the task. It is asked to adapt the selected reasoning modules to the task.
3. **Implement:** The LLM is provided the _adapted_ `reasoning modules` The adapted reasoning modules are transformed into a step-by-step task specific reasoning structure.

### Solving Phase - Apply Discovered Reasoning Structure to Task

1. LLM is provided a `task` and the `reasoning structure` and is asked to solve the task using the reasoning structure.
2. LLM is tasked with extracting the answer from the reasoned resposne (This isn't part of the paper.)

## Example Output:

```commandline
2024-02-11T08:10:08.003-07:00  INFO 17936 --- [           main] c.j.s.service.ReasoningService           : Composing reasoning structure for task: Lisa has 10 apples. She gives 3 apples to her friend and then buys 5 more apples from the store. How many apples does Lisa have now?
2024-02-11T08:10:11.543-07:00  INFO 17936 --- [           main] c.j.s.service.ReasoningService           : Selected reasoning modules: - How can I simplify the problem so that it is easier to solve?
- Critical Thinking: This style involves analyzing the problem from different perspectives, questioning assumptions, and evaluating the evidence or information available.
- Use Reflective Thinking: Step back from the problem, take the time for introspection and self-reflection. Examine personal biases, assumptions, and mental models that may influence problem-solving, and being open to learning from past experiences to improve future approaches.
- What are the potential obstacles or challenges that might arise in solving this problem?
- Are there any relevant data or information that can provide insights into the problem? If yes, what data sources are available, and how can they be analyzed?
- How can progress or success in solving the problem be measured or evaluated?
- Does the problem involve decision-making or planning, where choices need to be made under uncertainty or with competing objectives?
- What kinds of solution typically are produced for this kind of problem specification?
- Let’s think step by step.
- Let’s make a step by step plan and implement it with good notion and explanation.
2024-02-11T08:10:19.110-07:00  INFO 17936 --- [           main] c.j.s.service.ReasoningService           : Adapted reasoning modules: UPDATED REASONING MODULES:
- How can I simplify the problem so that it is easier to solve? (Simplify the problem by breaking it down into smaller steps or using visual aids to represent the quantities of apples)
- Critical Thinking: This style involves analyzing the problem from different perspectives, questioning assumptions, and evaluating the evidence or information available. (Apply critical thinking to understand the given information, identify any missing or unclear details, and ensure logical consistency)
- Use Reflective Thinking: Step back from the problem, take the time for introspection and self-reflection. Examine personal biases, assumptions, and mental models that may influence problem-solving, and being open to learning from past experiences to improve future approaches. (Reflect on past experiences with similar problems or concepts, and consider any biases or assumptions that may affect the problem-solving process)
- What are the potential obstacles or challenges that might arise in solving this problem? (Identify potential obstacles such as mathematical operations, understanding the given information, or conceptual misunderstandings)
- Are there any relevant data or information that can provide insights into the problem? If yes, what data sources are available, and how can they be analyzed? (Analyze the given information, such as the initial quantity of apples, the number of apples given away, and the number of apples bought, to determine the total quantity of apples Lisa has now)
- How can progress or success in solving the problem be measured or evaluated? (Measure success by accurately calculating the total number of apples Lisa has after giving some away and buying more)
- Does the problem involve decision-making or planning, where choices need to be made under uncertainty or with competing objectives? (No, the problem does not involve decision-making or planning with competing objectives)
- What kinds of solution typically are produced for this kind of problem specification? (Typically, a numerical solution is produced, indicating the final quantity of apples Lisa has)
- Let’s think step by step. (Break down the problem into individual steps, such as subtracting the apples given away and adding the apples bought)
- Let’s make a step by step plan and implement it with good notion and explanation. (Create a detailed plan outlining the steps to solve the problem, including explanations for each step)
2024-02-11T08:10:24.847-07:00  INFO 17936 --- [           main] c.j.s.service.ReasoningService           : Reasoning plan: {
  "steps": [
    {
      "step": "Simplify the problem",
      "substeps": [
        "Break down the problem into smaller steps",
        "Represent the quantities of apples visually"
      ]
    },
    {
      "step": "Apply critical thinking",
      "substeps": [
        "Understand the given information",
        "Identify any missing or unclear details",
        "Ensure logical consistency"
      ]
    },
    {
      "step": "Reflect on past experiences",
      "substeps": [
        "Consider biases or assumptions that may affect problem-solving",
        "Recall past experiences with similar problems or concepts"
      ]
    },
    {
      "step": "Identify potential obstacles",
      "substeps": [
        "Identify mathematical operations involved",
        "Ensure understanding of the given information",
        "Address conceptual misunderstandings"
      ]
    },
    {
      "step": "Analyze given information",
      "substeps": [
        "Determine the initial quantity of apples Lisa has",
        "Calculate the number of apples given away",
        "Determine the number of apples bought"
      ]
    },
    {
      "step": "Measure success",
      "substeps": [
        "Accurately calculate the total number of apples Lisa has"
      ]
    },
    {
      "step": "No decision-making or planning involved"
    },
    {
      "step": "Typical solution",
      "substeps": [
        "Numerical solution indicating the final quantity of apples Lisa has"
      ]
    },
    {
      "step": "Break down the problem",
      "substeps": [
        "Subtract the apples given away",
        "Add the apples bought"
      ]
    },
    {
      "step": "Create a step by step plan",
      "substeps": [
        "Outline the steps to solve the problem",
        "Provide explanations for each step"
      ]
    }
  ]
}

Answer: 12
```
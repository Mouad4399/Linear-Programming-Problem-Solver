# About : Linear-Programming-Problem-Solver
I created a program that implements the "vertex enumeration" or "corner point method" to calculate the optimal solution for real linear programming problems of any dimension . Currently , I am improving the error handling of my algorithm by providing informative messages ,thus enabling better interpretation of the results.

# Linear Programming Solver - Vertex Enumeration Method
This repository contains a Java program that implements the vertex enumeration or corner point method to solve real linear programming problems of any dimension.

## Overview
The program uses the Simplex algorithm to find the optimal solution for a linear programming problem. It iterates over the constraints and checks if the current solution is feasible and optimal. If the solution is feasible but not optimal, it performs a pivot operation to move to a better solution.

![iterations](https://github.com/Mouad4399/Linear-Programming-Problem-Solver/assets/130489466/05d1416c-f6e9-4555-97f7-b65bb424cff4)

## Methodology
The method used in this program is known as the "Vertex Enumeration" or "Corner Point" method. Here's a detailed explanation of the method:

Problem Formulation: The first step in solving an LP problem is to formulate it in mathematical terms. This involves defining the objective function (which you want to maximize or minimize) and the constraints (which are the limitations or restrictions on the decision variables).

Vertex Identification: The next step is to identify the vertices or corner points of the feasible region. The feasible region is the set of all possible solutions that satisfy the constraints. In a graphical representation, it's the area enclosed by the constraint lines. The vertices are the points where two or more constraint lines intersect.

![Feasible-region-gray-colored-region-and-non-feasible-region-are-defined-by-a-set-of](https://github.com/Mouad4399/Linear-Programming-Problem-Solver/assets/130489466/b55915c8-2e51-4776-b3d1-3c051f038bef)


Evaluation at Vertices: Once you've identified the vertices, you evaluate the objective function at each vertex. This involves substituting the coordinates of the vertex into the objective function and calculating the result.

Optimal Solution: The optimal solution is the vertex that gives the best value of the objective function. If you're maximizing, it's the vertex with the highest value. If you're minimizing, it's the vertex with the lowest value.

## Usage
To use this program, you need to provide the matrices and vectors representing the constraints and the objective function of the linear programming problem. The program will then calculate and print the optimal solution to the console.

## Requirements
Java Development Kit (JDK)
Installation
Clone this repository to your local machine.
Compile the Java program using the Java Compiler (javac).
Run the program using the Java Virtual Machine (java).

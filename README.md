# WorkingSimulation
Basic multithreading to stimulate a workspace


The purpose of this program is to simulate the behavior of a number of people in their workplace, taking breaks (fika) to socialize and energize.

An individual has a unique name and an energy level represented by integer values, where 0 represents the lowest level below which that individual leaves the workplace and returns home, and 100 represents the minimum level at which the individual returns to work. When a person is weak (energy level *30), that individual uses the coffee machine in the coffee room. A BlackCoffee gives 15-20 calories, a Capuccino gives 20-30 calories, and a Latte gives 25-35 calories. Two seconds are required for the coffee machine to produce a hot beverage that is added to its reserve. As long as there is at least one drink in the reserve at all times, the machine can supply one drink to one worker each second. The reserve can hold a maximum of twenty drinks at a time.

There will be a queue for the coffee machine, and workers will be served in a FIFO fashion. A worker will return to the end of the queue if their energy level is still below 100 after drinking a cup

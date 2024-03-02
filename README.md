# Stuff the project doesn't care about / handle as of now:
* Multiple candies of the same class
* Multiple constructors in a class annotated with Candies
* Candy dependencies DAG more than one layer deep
* Candy annotations on anything other than class
    * ie, Candy annotations on methods that return a certain object don't work.
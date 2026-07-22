### Exercise: Ai Assisted Debugging


## BUG 1 

**Prompt:** My java program crashes with this stack trace:Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.startsWith(String)" because "studentNames[i]" is null
	at Week1.Wedensday.AiAssistedDebugging.RosterApp.main(RosterApp.java:11)
Explain the root cause of the error and provide a clean fix that enforces boundary validation checks instead of catching the exception.

**Output:** Root cause (short): the array has null entries (only indices 0–1 set). The code calls studentNames[i].startsWith(...), which throws NullPointerException when studentNames[i] is null.
Clean fix: validate entries before calling methods. Updated the loop to skip nulls and use a local variable:
Updated loop: for (int i = 0; i < studentNames.length; i++) {     // Skip uninitialized (null) entries to avoid NullPointerException     String name = studentNames[i];     if (name == null) {         continue;     }
    if (name.startsWith("A")) {        System.out.println("Student: " + name);    }
}
This enforces boundary/state checks instead of catching the exception. If you prefer to only iterate populated entries, consider tracking a count of inserted names or using a List<String> and iterating over it.


**Resolution** Correctly adjusted to account for null elements

## BUG 2

**Prompt:** My java program crashes with the this stack trace:Exception in thread "main" java.lang.ClassCastException: class Week1.Wedensday.AiAssistedDebugging.Airplane cannot be cast to class Week1.Wedensday.AiAssistedDebugging.Car (Week1.Wedensday.AiAssistedDebugging.Airplane and Week1.Wedensday.AiAssistedDebugging.Car are in unnamed module of loader 'app')
	at Week1.Wedensday.AiAssistedDebugging.AirportApp.main(AirportApp.java:11)
Explain the root cause of the error and suggest a clean fix that enforces boundary validation checks instead of catching the exception.

**Output:** Root cause (short): code attempts to downcast an Airplane instance to Car at runtime. That violates the JVM type system and throws ClassCastException.
Fix approach (boundary validation): check the object's type before casting, or avoid downcasts by using typed collections or polymorphism. Implemented instanceof guard in main:
Updated snippet: if (myVehicle instanceof Car) {     Car myCar = (Car) myVehicle;     System.out.println("Vehicle downcasted successfully."); } else {     System.out.println("myVehicle is not a Car; it's a " + myVehicle.getClass().getSimpleName() + ". Skipping downcast."); }
Notes:
•
Prefer List<Car> when only cars are expected, or define common behavior in Vehicle and call methods polymorphically to eliminate casts entirely.


**Resolution** Correctly implements instanceof check to guard BEFORE casting


## BUG 3

**Prompt:**My java program crashes with the this stack trace:Exception in thread "main" java.lang.ArithmeticException: / by zero
	at Week1.Wedensday.AiAssistedDebugging.FinancialApp.computeScore(FinancialApp.java:5)
	at Week1.Wedensday.AiAssistedDebugging.FinancialApp.main(FinancialApp.java:10)
Explain the root cause of the error and suggest a clean fix that enforces boundary validation checks instead of catching the exception.

**Output:** Root cause (short): division by zero — computeScore did totalScore / divisor while divisor was 0, causing ArithmeticException.
Clean fix (boundary validation): validate the divisor before dividing. Updated code validates and either reports the invalid input or enforces a precondition:
•
computeScore now checks divisor != 0 and throws IllegalArgumentException with a clear message.
•
main validates the divisor before calling computeScore and prints a friendly message instead of letting the program crash.
This enforces input/precondition checks rather than relying on catching the ArithmeticException. For production, prefer validating user input earlier or using Optional/Result types for absence handling.


**Resolution** Correctly implements divide by zero guardrails
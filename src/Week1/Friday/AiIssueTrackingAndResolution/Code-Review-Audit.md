# Code Review Audit: TaskManager

## Class Reviewed
`Week1.Friday.CollectionsChallange.com.cohort.tasks.TaskManager`

## AI Critique Points

1. **Readability**: `getTaskid()` violates Java camelCase convention, should be `getTaskId()`. System.out used for control flow messages instead of a logger.
2. **Performance**: No N^2 loops. Small allocations are fine. AI suggested reading `task.getTitle()` and `task.getTaskId()` once into local variables to avoid repeated method calls.
3. **Exception Safety**: No null checks on task, id, or title inputs. Duplicate ID not checked — silent overwrite possible.
4. **Encapsulation**: Internal collection fields not marked final. No defensive copies returned from getters.
5. **Thread Safety**: Public mutating methods not synchronized. Collections not thread-safe.
6. **Structure**: Demo main() present in production class.

---

## Implementation Decisions

### Accepted

**Rename `getTaskid()` to `getTaskId()`**
Standard Java camelCase convention. Simple fix with no behavioral impact.

**Input validation for null/empty task, id, and title**
Most important feedback. Silent failures or NullPointerExceptions are a real risk. Added null and empty checks to addTask().

**Duplicate ID check**
Valid gap. The original only blocked duplicate titles. A duplicate ID would silently overwrite an existing task in the map. Added check for existing ID before inserting.

**Mark collection fields final**
Making `allTasks`, `uniqueTitles`, and `taskLookup` final prevents accidental reference reassignment. The collections themselves remain mutable. Accepted because it costs nothing and adds safety.

**JavaDoc on public methods**
Accepted. Clear documentation of method contracts improves readability and is standard professional practice.

**Read title and id into local variables once**
Minor but cleaner. Avoids repeated method calls and makes the code easier to read.

### Rejected

**Replace System.out with java.util.logging.Logger**
Rejected. `java.util.logging` has not been covered in the curriculum at this stage. System.out is appropriate for a training context and the exercise does not require production logging infrastructure.

**Case-insensitive title normalization**
Rejected. The exercise specification does not require case-insensitive uniqueness. Adding this behavior would change the contract of the class beyond what was asked.

**Thread safety (synchronized methods, concurrent collections)**
Rejected. Concurrency has not been covered in the Week 1 curriculum. This is a valid production concern but is out of scope for this exercise. Will revisit when concurrency topics are introduced.

**Defensive copies on getters**
Rejected for the same reason as thread safety. This is a production pattern that assumes untrusted callers modifying returned collections. Not applicable to this training context.

**Move main() to a separate demo or test class**
Rejected. This class is intentionally a demo class. The main method exists to demonstrate and test TaskManager behavior as part of the exercise. In a production codebase this would be separated, but that distinction is not relevant here.

---

## Refactored Code Changes

- Renamed `getTaskid()` to `getTaskId()` throughout
- Added null and empty checks for task, id, and title at the top of `addTask()`
- Added duplicate ID check before inserting into taskLookup
- Marked collection fields final
- Added local variable reads for id and title inside addTask()
- Added JavaDoc comments to public methods
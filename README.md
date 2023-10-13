# Library management system
 This is a university project that was created 
 for Modern Programming practices course.
  
## Introducing the team:
- [Kerim Amansaryyev](https://github.com/kerimamansaryyev)
- [Ivan Agaba](https://github.com/agabaivan)
- [James Balimunsi](https://github.com/jamesbali)

# Structure and architecture
- In this project we used the DDD (Domain Driven Design)
software design as for a whole architecture. 
- For proper control distribution
of responsibilities among sub-systems we used the Facade design pattern.

## Major packages:

### Data layer
- `data.data_access` - the sub-system for managing IO operation on the records.
- `data.library_system` - contains  `LibrarySystemImpl` class
that implements `LibrarySystem` domain class. The implementation class
interacts with `DataAccessFacade` to provide respective implementation per
operation.

### Domain Layer
- `domain.library_system.auth` - contains class `User` and
`AuthFacade` that manages operations on an instance of `User`.
`AuthFacade`'s methods must be executed only upon using `LibrarySystemFacade`.
- `domain.entities` - contains major domain entities presented in the
project. Domain entities that involve composition, aggregation or 
strong association are utilized into packages. Those entities are
encapsulated and may be restricted on creation, modification and e.t.c
by corresponding facade class. For example, operations on the entities
inside `domain.entities.book` can be achieved by referring to `BookFacade`
class.
- `domain.library_system` - contains domain sub-packages introduced below
and 2 classes. `LibrarySystem` - is a primary abstraction that implements
all the operation of the system. `LibrarySystemFacade` - the main facade
that provides APIs to interact with the presentation layer.
- `domain.library_system.exceptions` - a package that contains various exceptions
that may occur in the system. Typically, each exception in the package
extends `LibrarySystemException`.
- `domain.library_system.operations` - contains interfaces of
main operations (use-cases). `LibrarySystem` implementers are
supposed to implement each operation in the package. Although,
an instance of `User` can't directly use `LibrarySystem` implementer,
it is being granted an instance of `Access` abstraction whose subclasses
can execute **particular** operations.
- `domain.library_system.usecases` - a package that contains classes
with static methods for executing methods using an instance of the operation
interfaces. They must be executed only upon using `LibrarySystemFacade`.
- `domain.library_system.user_access` - contains subclasses of `Access`
abstraction. These classes appear to be intermediate classes between
an actor (an instance of `User` class) and implementer of `LibrarySystem`.
They implement some limited amount of the operation interfaces to restrict
access for the system.

### Presentation Layer
- `presentation.navigation` - contains classes for navigation
between windows, provides `AppNavigationFacade` 
for client classes (often windows) to interact with `AppNavigator`.
`AppNavigator` manages internal `AppNavigationStack` top "pop"
and "push" windows.
- `presentation.windows` - contains packages with the windows (pages).
Each window implements `AppNavigationWindow` interface so it can be
managed by `AppNavigator`.


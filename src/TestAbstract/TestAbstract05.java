// MainApp test application
class TestAbstract05 {

  public static void main(String[] args) {
    Context context;
    // contexts 1
    context = new Context(new ConcreteStrategyA());
    context.execute();
    // contexts 2
    context = new Context(new ConcreteStrategyB());
    context.execute();
    // contexts 3
    context = new Context(new ConcreteStrategyC());
    context.execute();
  }

}

// The classes that implement a concrete strategy should implement this
// The context class uses this to call the concrete strategy
interface IStrategy {
  void execute();
}

// Implements the algorithm using the strategy interface
class ConcreteStrategyA implements IStrategy {
  public void execute() {
    System.out.println( "Called ConcreteStrategyA.execute()" );
  }
}

class ConcreteStrategyB implements IStrategy {
  public void execute() {
    System.out.println( "Called ConcreteStrategyB.execute()" );
  }
}

class ConcreteStrategyC implements IStrategy {
  public void execute() {
    System.out.println( "Called ConcreteStrategyC.execute()" );
  }
}

// Configured with a ConcreteStrategy object and maintains a reference
// to a Strategy object
class Context {
  IStrategy strategy;

  // Constructor
  public Context(IStrategy strategy) {
    this.strategy = strategy;
  }

  public void execute() {
    strategy.execute();
  }
}

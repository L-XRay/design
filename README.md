# Java设计模式

设计模式遵循六⼤原则：

1. 单⼀职责( ⼀个类和⽅法只做⼀件事 )
2. ⾥⽒替换( 多态，⼦类可扩展⽗类 )
3. 依赖倒置( 细节依赖抽象，下层依赖上层 )
4. 接⼝隔离( 建⽴单⼀接⼝ )
5. 迪⽶特原则( 最少知道，降低耦合 )
6. 开闭原则( 抽象架构，扩展实现 )



------



## 创建者模式

**这类模式提供创建对象的机制，能够提升已有代码的灵活性和可复用性**

创建者模式包括：⼯⼚⽅法、抽象⼯⼚、⽣成器、原型、单例，这5类。

### 工厂方法模式

⼯⼚模式⼜称⼯⼚⽅法模式，是⼀种创建型设计模式，其在⽗类中提供⼀个创建对象的⽅法， 允许⼦类决定实例化对象的类型。它的主要意图是定义⼀个创建对象的接⼝，让其⼦类⾃⼰决定实例化哪⼀个⼯⼚类，⼯⼚模式使其创建过程延迟到⼦类进⾏。

简单说就是为了提供代码结构的扩展性，屏蔽每⼀个功能类中的具体实现逻辑。让外部可以更加简单的只是知道调⽤即可。

业务场景：

多种类型商品不同接口，统一发奖服务搭建场景

### 抽象工厂模式

抽象⼯⼚模式与⼯⼚⽅法模式虽然主要意图都是为了解决，**接⼝选择**问题。但在实现上，抽象⼯⼚是⼀个中⼼⼯⼚，创建其他⼯⼚的模式。

抽象⼯⼚模式，所要解决的问题就是在⼀个产品族，存在多个不同类型的产品(Redis集群、操作系统)情况下，接⼝选择的问题。

业务场景：

替换Redis双集群升级，代理类抽象场景

### 建造者模式

**建造者模式所完成的内容就是通过将多个简单对象通过⼀步步的组装构建出⼀个复杂对象的过程。**

例如你玩王者荣耀的时的初始化界⾯；有三条路、有树⽊、有ᰀ怪、有守卫塔等等，甚⾄依赖于你的⽹络情况会控制清晰度。⽽当你换⼀个场景进⾏其他不同模式的选择时，同样会建设道路、树⽊、野怪等等，但是他们的摆放和⼤⼩都有不同。这⾥就可以⽤到建造者模式来初始化游戏元素。

⽽这样的根据相同的 物料 ，不同的组装所产⽣出的具体的内容，就是建造者模式的最终意图，也就是；

**将⼀个复杂的构建与其表示相分离，使得同样的构建过程可以创建不同的表示。**

业务场景：

各项装修物料组合套餐选配场景

### 原型模式

原型模式主要解决的问题就是创建重复对象，⽽这部分 对象 内容本身⽐较复杂，⽣成过程可能从库或者RPC接⼝中获取数据的耗时较⻓，因此采⽤克隆的⽅式节省时间。

在原型模式中所需要的⾮常重要的⼿段就是克隆，在需要⽤到克隆的类中都需要实现 implements Cloneable 接⼝。

业务场景：

上机考试多套试卷，每⼈题⽬和答案乱序排列场景

### 单例模式

单例模式可以说是整个设计中最简单的模式之⼀，⽽且这种⽅式即使在没有看设计模式相关资料也会常⽤在编码开发中。因为在编程开发中经常会遇到这样⼀种场景，那就是需要保证⼀个类只有⼀个实例哪怕多线程同时访问，并需要提供⼀个全局访问此实例的点。

综上以及我们平常的开发中，可以总结⼀条经验，单例模式主要解决的是，⼀个全局使⽤的类频繁的创建和消费，从⽽提升提升整体的代码的性能。

业务场景：

1. 数据库的连接池不会反复创建

2. spring中⼀个单例模式bean的⽣成和使⽤

3. 在我们平常的代码中需要设置全局的的⼀些属性保存

单例模式的实现⽅式⽐较多，主要在实现上是否⽀持懒汉模式、是否线程安全中运⽤各项技巧。当然也有⼀些场景不需要考虑懒加载也就是懒汉模式的情况，会直接使⽤ static 静态类或属性和⽅法的⽅式进⾏处理，供外部调⽤。

- #### 静态类使用

  ```java
  public class Singleton_00 {
  
      public static Map<String,String> cache = new ConcurrentHashMap<String, String>();
  
  }
  ```

  - 以上这种⽅式在我们平常的业务开发中⾮常常⻅，这样静态类的⽅式可以在第⼀次运⾏的时候直接初始化Map类，同时这⾥我们也不需要到延迟加载在使⽤。
  - 在不需要维持任何状态下，仅仅⽤于全局访问，这个使⽤静态类的⽅式更加⽅便。
  - 但如果需要被继承以及需要维持⼀些特定状态的情况下，就适合使⽤单例模式。

- #### 懒汉模式(线程不安全)

  ```java
  public class Singleton_01 {
  
      private static Singleton_01 instance;
  
      private Singleton_01() {
      }
  
      public static Singleton_01 getInstance(){
          if (null != instance) return instance;
          return new Singleton_01();
      }
  
  }
  ```

  - 单例模式有⼀个特点就是不允许外部直接创建，也就是 new Singleton_01() ，因此这⾥在默认的构造函数上添加了私有属性 private 。
  - ⽬前此种⽅式的单例确实满⾜了懒加载，但是如果有多个访问者同时去获取对象实例你可以想象成⼀堆⼈在抢厕所，就会造成多个同样的实例并存，从⽽没有达到单例的要求。

- #### 懒汉模式(线程安全)

  ```java
  public class Singleton_02 {
  
      private static Singleton_02 instance;
  
      private Singleton_02() {
      }
  
      public static synchronized Singleton_02 getInstance(){
          if (null != instance) return instance;
          instance = new Singleton_02();
          return instance;
      }
  
  }
  ```

  - 此种模式虽然是安全的，但由于把锁加到⽅法上后，所有的访问都因需要锁占⽤导致资源的浪费。
  - 如果不是特殊情况下，不建议此种⽅式实现单例模式。

- #### 饿汉模式(线程安全)

  ```java
  public class Singleton_03 {
  
      private static Singleton_03 instance = new Singleton_03();
  
      private Singleton_03() {
      }
  
      public static Singleton_03 getInstance() {
          return instance;
      }
  
  }
  ```

  - 此种⽅式与我们开头的第⼀个实例化 Map 基本⼀致，在程序启动的时候直接运⾏加载，后续有外部需要使⽤的时候获取即可。
  - 但此种⽅式并不是懒加载，也就是说⽆论你程序中是否⽤到这样的类都会在程序启动之初进⾏创建。
  - 那么这种⽅式导致的问题就像你下载个游戏软件，可能你游戏地图还没有打开呢，但是程序已经将这些地图全部实例化。到你⼿机上最明显体验就⼀开游戏内存满了，⼿机卡了，需要换了。

- #### 使用类的内部类(线程安全)

  ```java
  public class Singleton_04 {
  
      private static class SingletonHolder {
          private static Singleton_04 instance = new Singleton_04();
      }
  
      private Singleton_04() {
      }
  
      public static Singleton_04 getInstance() {
          return SingletonHolder.instance;
      }
  
  }
  ```

  - 使⽤类的静态内部类实现的单例模式，既保证了线程安全有保证了懒加载，同时不会因为加锁的⽅式耗费性能。
  - 这主要是因为JVM虚拟机可以保证多线程并发访问的正确性，也就是⼀个类的构造⽅法在多线程环境下可以被正确的加载。
  - 此种⽅式也是⾮常推荐使⽤的⼀种单例模式

- #### 双重锁校验(线程安全)

  ```java
  public class Singleton_05 {
  
      private static volatile Singleton_05 instance;
  
      private Singleton_05() {
      }
  
      public static Singleton_05 getInstance(){
         if(null != instance) return instance;
         synchronized (Singleton_05.class){
             if (null == instance){
                 instance = new Singleton_05();
             }
         }
         return instance;
      }
  
  }
  ```

  - 双重锁的⽅式是⽅法级锁的优化，减少了部分获取实例的耗时。
  - 同时这种⽅式也满⾜了懒加载。

- ####  **CAS**「**AtomicReference**」(**线程安全**)

  ```java
  public class Singleton_06 {
  
      private static final AtomicReference<Singleton_06> INSTANCE = new AtomicReference<Singleton_06>();
  
      private static Singleton_06 instance;
  
      private Singleton_06() {
      }
  
      public static final Singleton_06 getInstance() {
          for (; ; ) {
              Singleton_06 instance = INSTANCE.get();
              if (null != instance) return instance;
              INSTANCE.compareAndSet(null, new Singleton_06());
              return INSTANCE.get();
          }
      }
  
      public static void main(String[] args) {
          System.out.println(Singleton_06.getInstance()); // org.itstack.demo.design.Singleton_06@2b193f2d
          System.out.println(Singleton_06.getInstance()); // org.itstack.demo.design.Singleton_06@2b193f2d
      }
  }
  ```

  - ava并发库提供了很多原⼦类来⽀持并发访问的数据安全性；
  -  AtomicInteger 、 AtomicBoolean 、 AtomicLong 、 AtomicReference 。
  - AtomicReference 可以封装引⽤⼀个V实例，⽀持并发访问如上的单例⽅式就是使⽤了这样的⼀个特点。
  - 使⽤CAS的好处就是不需要使⽤传统的加锁⽅式保证线程安全，⽽是依赖于CAS的忙等算法，依赖于底层硬件的实现，来保证线程安全。相对于其他锁的实现没有线程的切换和阻塞也就没有了额外的开销，并且可以⽀持较⼤的并发性。
  - 当然CAS也有⼀个缺点就是忙等，如果⼀直没有获取到将会处于死循环中。

- #### **Effffective Java**作者推荐的枚举单例**(**线程安全)

  ```java
  public enum Singleton_07 {
  
      INSTANCE;
      public void test(){
          System.out.println("hi~");
      }
  
  }
  ```

  - Effffective Java 作者推荐使⽤枚举的⽅式解决单例模式，此种⽅式可能是平时最少⽤到的。
  - 这种⽅式解决了最主要的；线程安全、⾃由串⾏化、单⼀实例。

  **调用方式**

  ```java
  
      public void test() {
          Singleton_07.INSTANCE.test();
      }
  
  ```

  - 这种写法在功能上与共有域⽅法相近，但是它更简洁，⽆偿地提供了串⾏化机制，绝对防⽌对此实例化，即使是在⾯对复杂的串⾏化或者反射攻击的时候。虽然这种⽅法还没有⼴泛采⽤，但是单元素的枚举类型已经成为实现*Singleton*的最佳⽅法。
  - 但也要知道此种⽅式在存在继承场景下是不可⽤的。



------



## 结构型模式

**这类模式介绍如何将对象和类组装成较⼤的结构， 并同时保持结构的灵活和⾼效。**

结构型模式包括：适配器、桥接、组合、装饰器、外观、享元、代理，这7类。

### 适配器模式

适配器模式的主要作⽤就是把原本不兼容的接⼝，通过适配修改做到统⼀。使得⽤户⽅便使⽤，就像我们提到的万能充、数据线、MAC笔记本的转换头、出国旅游买个插座等等，他们都是为了适配各种不同的插⼝ ，做的兼容。

在业务开发中我们会经常的需要做不同接⼝的兼容，尤其是中台服务，中台需要把各个业务线的各种类型服务做统⼀包装，再对外提供接⼝进⾏使⽤。⽽这在我们平常的开发中也是⾮常常⻅的。

业务场景：

从多个MQ消息体中，抽取指定字段值场景

### 桥接模式

桥接模式的主要作⽤就是通过将抽象部分与实现部分分离，把多种可匹配的使⽤进⾏组合。说⽩了核⼼实现也就是在A类中含有B类接⼝，通过构造函数传递B类的实现，这个B类就是设计的 桥 。

JDBC多种驱动程序的实现、同品牌类型的台式机和笔记本平板、业务实现中的多类接⼝同组过滤服务等。这些场景都⽐较适合使⽤桥接模式进⾏实现，因为在⼀些组合中如果有如果每⼀个类都实现不同的服务可能会出现笛卡尔积，⽽使⽤桥接模式就可以⾮常简单。

桥接模式的关键是选择的桥接点拆分，是否可以找到这样类似的相互组合，如果没有就没必要⾮得使⽤桥接模式

业务场景：

多⽀付渠道(微信、⽀付宝)与多⽀付模式(刷脸、指纹)场景

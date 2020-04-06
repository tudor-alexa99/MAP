package View;

import Controller.Controller_;
import Model.ADT.*;
import Model.DataTypes.*;
import Model.Exceptions.MyException;
import Model.Expressions.*;
import Model.ProgramState;
import Model.Statements.*;
import Model.Statements.Heap.HeapWritingStatement;
import Model.Statements.Heap.NewStatement;
import Model.Values.BoolValue;
import Model.Values.IntValue;
import Model.Values.StringValue;
import Repository.Repository;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;

public class main {

    public static void main(String[] args) {
//        MyIStack<IStatement> exeStack = new MyStack<IStatement>();
//        MyIDictionary<String, Value> symTable = new MyDictionary<String, Value>();
//        MyIList<Value> out = new MyList<Value>();
//
        IStatement ex1 = main.ex1();
        IStatement ex2 = main.ex2();
        IStatement ex3 = main.ex3();
        IStatement ex4 = main.ex4();
        IStatement ex5 = main.ex5();
        IStatement ex6 = main.ex6();
        IStatement ex7 = main.ex7();
        IStatement ex8 = main.ex8();
        IStatement ex9 = main.ex9();
        IStatement ex10 = main.ex10();
        IStatement ex12 = main.ex12();
        IStatement ex13 = main.ex13();
        IStatement ex14 = main.ex14();
        IStatement ex15 = main.ex15();
        IStatement ex16 = main.ex16();
        IStatement ex17 = main.ex17();
        IStatement ex18 = main.ex18();
        IStatement ex19 = main.ex19();
        IStatement ex20 = main.ex20();

//        ProgramState programState1 = new ProgramState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(),ex1, new MyHeap<>());
//        Repository repo1 = new Repository(programState1, "./src/Repository/logFile1");
//        Controller_ ctrl1 = new Controller_(repo1);
//
//        ProgramState programState2 = new ProgramState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(),ex2,new MyHeap<>());
//        Repository repo2 = new Repository(programState1, "./src/Repository/logFile2");
//        Controller_ ctrl2 = new Controller_(repo2);
//
//        ProgramState programState3 = new ProgramState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(),ex3,new MyHeap<>());
//        Repository repo3 = new Repository(programState1, "./src/Repository/logFile3");
//        Controller_ ctrl3 = new Controller_(repo3);
//
//        ProgramState programState4 = new ProgramState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(),ex4,new MyHeap<>());
//        Repository repo4 = new Repository(programState4, "./src/Repository/logFile4");
//        Controller_ ctrl4 = new Controller_(repo4);
//
//        ProgramState programState5 = new ProgramState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(),ex5, new MyHeap<>());
//        Repository repo5 = new Repository(programState5, "./src/Repository/logFile5");
//        Controller_ ctrl5 = new Controller_(repo5);
//
//        ProgramState programState6 = new ProgramState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(),ex6, new MyHeap<>());
//        Repository repo6 = new Repository(programState6, "./src/Repository/logFile6");
//        Controller_ ctrl6 = new Controller_(repo6);
//
//        ProgramState programState7 = new ProgramState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(),ex7, new MyHeap<>());
//        Repository repo7 = new Repository(programState7, "./src/Repository/logFile7");
//        Controller_ ctrl7 = new Controller_(repo7);
//
//        ProgramState programState8 = new ProgramState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(),ex8, new MyHeap<>());
//        Repository repo8 = new Repository(programState8, "./src/Repository/logFile8");
//        Controller_ ctrl8 = new Controller_(repo8);
//
//        ProgramState programState9 = new ProgramState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(),ex9, new MyHeap<>());
//        Repository repo9 = new Repository(programState9, "./src/Repository/logFile9");
//        Controller_ ctrl9 = new Controller_(repo9);
//
//        ProgramState programState10= new ProgramState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(),ex10, new MyHeap<>());
//        Repository repo10= new Repository(programState10, "./src/Repository/logFile10");
//        Controller_ ctrl10= new Controller_(repo10);
//
//        ProgramState programState12= new ProgramState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(),ex12, new MyHeap<>());
//        Repository repo12= new Repository(programState12, "./src/Repository/logFile12");
//        Controller_ ctrl12= new Controller_(repo12);
//
//        ProgramState programState13= new ProgramState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(),ex13, new MyHeap<>());
//        Repository repo13= new Repository(programState13, "./src/Repository/logFile13");
//        Controller_ ctrl13= new Controller_(repo13);
//
//        ProgramState programState14= new ProgramState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(),ex14, new MyHeap<>());
//        Repository repo14= new Repository(programState14, "./src/Repository/logFile14");
//        Controller_ ctrl14= new Controller_(repo14);
//
//        ProgramState programState17= new ProgramState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(),ex17, new MyHeap<>());
//        Repository repo17= new Repository(programState17, "./src/Repository/logFile17");
//        Controller_ ctrl17= new Controller_(repo17);
//
        ProgramState programState18= new ProgramState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(),ex18, new MyHeap<>(), new LatchTable());
        Repository repo18= new Repository(programState18, "./src/Repository/logFile18");
        Controller_ ctrl18= new Controller_(repo18);

        ProgramState programState19= new ProgramState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(),ex19, new MyHeap<>(), new LatchTable());
        Repository repo19= new Repository(programState19, "./src/Repository/logFile19");
        Controller_ ctrl19= new Controller_(repo19);


        ProgramState programState20= new ProgramState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(),ex20, new MyHeap<>(), new LatchTable());
        Repository repo20= new Repository(programState20, "./src/Repository/logFile20");
        Controller_ ctrl20= new Controller_(repo20);

        TextMenu menu = new TextMenu();
//        menu.addCommand(new ExitCommand("0", "exit"));
//        menu.addCommand(new RunExample("1",ex1.toString(),ctrl1));
//        menu.addCommand(new RunExample("2",ex2.toString(),ctrl2));
//        menu.addCommand(new RunExample("3",ex3.toString(),ctrl3));
//        menu.addCommand(new RunExample("4",ex4.toString(),ctrl4));
//        menu.addCommand(new RunExample("5",ex5.toString(),ctrl5));
//        menu.addCommand(new RunExample("6",ex6.toString(),ctrl6));
//        menu.addCommand(new RunExample("7",ex7.toString(),ctrl7));
//        menu.addCommand(new RunExample("8",ex8.toString(),ctrl8));
//        menu.addCommand(new RunExample("9",ex9.toString(),ctrl9));
//        menu.addCommand(new RunExample("10",ex10.toString(),ctrl10));
//        menu.addCommand(new RunExample("12",ex12.toString(),ctrl12));
//        menu.addCommand(new RunExample("13",ex13.toString(),ctrl13));
//        menu.addCommand(new RunExample("14",ex14.toString(),ctrl14));
//        menu.addCommand(new RunExample("17",ex17.toString(),ctrl17));
        menu.addCommand(new RunExample("18",ex18.toString(),ctrl18));
        menu.addCommand(new RunExample("19",ex19.toString(),ctrl19));
        menu.addCommand(new RunExample("20",ex20.toString(),ctrl20));

//        try { //correct typeChecker
//            MyIDictionary<String, Type> typeEnv = new MyDictionary<>();
//            ex15.typecheck(typeEnv);
//            ProgramState programState15 = new ProgramState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(), ex15, new MyHeap<>());
//            Repository repo15 = new Repository(programState15, "./src/Repository/logFile15");
//            Controller_ ctrl15 = new Controller_(repo15);
//
//            menu.addCommand(new RunExample("15",ex15.toString(),ctrl15));
//        } catch (MyException m){
//            System.out.println(m.getMessage());
//        }

//        try { //error typeChecker
//            MyIDictionary<String, Type> typeEnv = new MyDictionary<>();
//            ex16.typecheck(typeEnv);
//            ProgramState programState16 = new ProgramState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(), ex16, new MyHeap<>());
//            Repository repo16 = new Repository(programState16, "./src/Repository/logFile16");
//            Controller_ ctrl16 = new Controller_(repo16);
//
//            menu.addCommand(new RunExample("16",ex16.toString(),ctrl16));
//        } catch (MyException m){
//            System.out.println(m.getMessage());
//        }

        menu.show();
//
//        try {
//            ctrl.allSteps();
//        }
//        catch(MyException e){
//            System.out.println(e.getMessage());
//        }
    }
    private static IStatement ex1(){
        //int v; v = 2; Print(v);

        IStatement ex1 = new CompStatement(new VarDeclStatement("v", new IntType()),new CompStatement (new AssignStatement("v", new ValueExpression(new IntValue(2))), new PrintStatement(new VarExpression("v"))));
        return ex1;
    }

    private static IStatement ex2(){
        // int a;int b; a=2+3*5;b=a+1;Print(b)
        IStatement ex2 = new CompStatement(
                new VarDeclStatement("a", new IntType()),
                new CompStatement(
                        new VarDeclStatement("b", new IntType()),
                        new CompStatement(
                                new AssignStatement(
                                        "a",
                                        new ArithExpression(
                                                new ValueExpression(new IntValue(2)),
                                                new ArithExpression(
                                                        new ValueExpression(new IntValue(3)),
                                                        new ValueExpression(new IntValue(5)),
                                                        '*'
                                                ),
                                                '+'
                                        )
                                ),
                                new CompStatement(
                                        new AssignStatement("b",
                                                new ArithExpression(
                                                        new VarExpression("a"),
                                                        new ValueExpression(new IntValue(1)),
                                                        '+'
                                                )
                                        ),
                                        new PrintStatement(new VarExpression("b"))
                                )

                        )
                ));
        return ex2;
    }

    private static IStatement ex3() {
        //bool a; int v; a=true;(If a Then v=2 Else v=3);Print(v)

        IStatement ex3 = new CompStatement(
                new VarDeclStatement("a",new BoolType()),
                new CompStatement(
                        new VarDeclStatement("v", new IntType()),
                        new CompStatement(
                                new AssignStatement("a", new ValueExpression(new BoolValue(true))),
                                new CompStatement(
                                        new IfStatement(
                                                new ArithExpression(
                                                        new VarExpression("a"),
                                                        new ValueExpression(new IntValue(1)),
                                                        '+'),
                                                new AssignStatement("v",
                                                        new ValueExpression(new IntValue(2))),
                                                new AssignStatement("v", new ValueExpression(new IntValue(3)))),
                                        new PrintStatement(new VarExpression("v"))))));

        return ex3;
    }

    private static IStatement ex4(){
        // string varf; varf="test.in"; openRFile(varf); int varc;
        //  readFile(varf,varc); print(varc); readFile(varf,varc);
        //  print(varc); closeRFile(varf)

        return new CompStatement(
                new VarDeclStatement("varf", new StringType()),
                new CompStatement(
                        new AssignStatement("varf", new ValueExpression(new StringValue("./src/Repository/test.in.txt"))),
                        new CompStatement(
                                new OpenRFileStatement(new VarExpression("varf")),
                                new CompStatement(
                                        new VarDeclStatement("varc", new IntType()),
                                        new CompStatement(
                                                new ReadFileStatement(
                                                        new VarExpression("varf"),
                                                        "varc"
                                                ),
                                                new CompStatement(
                                                        new PrintStatement(new VarExpression("varc")),
                                                        new CompStatement(
                                                                new ReadFileStatement(
                                                                        new VarExpression("varf"),
                                                                        "varc"
                                                                ),
                                                                new CompStatement(
                                                                        new PrintStatement(new VarExpression("varc")),
                                                                        new CompStatement(
                                                                                new CloseRFileStatement(new VarExpression("varf")),
                                                                                new CloseRFileStatement(new VarExpression("varf"))
                                                                        )
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                )
        );
    }

    private static IStatement ex5() {
        // bool v; v = 2 < 3; Print(v)
        return
                new CompStatement(
                        new VarDeclStatement("v", new BoolType()),
                        new CompStatement(
                                new AssignStatement(
                                        "v",
                                        new RelationalExpression(
                                                new ValueExpression(new IntValue(2)),
                                                new ValueExpression(new IntValue(3)),
                                                "<"
                                        )),
                                new PrintStatement(new VarExpression("v"))
                        )
                );
    }

    private static IStatement ex6() {
        // Ref int v; new(v,20); Ref Ref int a; new(a,v); new(v,30); print(rH(rH(a)))
        return
                new CompStatement(
                        new VarDeclStatement("v", new RefType(new IntType())),
                        new CompStatement(
                                new NewStatement("v", new ValueExpression(new IntValue(20))),
                                new CompStatement(
                                        new VarDeclStatement("a", new RefType(new RefType(new IntType()))),
                                        new CompStatement(
                                                new NewStatement("a", new VarExpression("v")),
                                                new CompStatement(
                                                        new NewStatement("v", new ValueExpression(new IntValue(30))),
                                                        new PrintStatement(new ReadHeapExpression(new ReadHeapExpression(new VarExpression("a"))))
                                                )
                                        )
                                )
                        )
                );
    }

    private static IStatement ex7(){
        // int v; v=4; (while (v>0) print(v);v=v-1);print(v)
        return
                new CompStatement(
                        new VarDeclStatement("v", new IntType()),
                        new CompStatement(
                                new AssignStatement("v", new ValueExpression(new IntValue(4))),
                                new CompStatement(
                                        new WhileStatement(
                                                new RelationalExpression(
                                                        new VarExpression("v"),
                                                        new ValueExpression(new IntValue(0)),
                                                        ">"
                                                ),
                                                new CompStatement(
                                                        new PrintStatement(new VarExpression("v")),
                                                        new AssignStatement("v", new ArithExpression(
                                                                new VarExpression("v"),
                                                                new ValueExpression(new IntValue(1)),
                                                                '-'
                                                        )
                                                )
                                        )),
                                        new PrintStatement(new VarExpression("v"))
                                )
                        )
                );
    }

    private static IStatement ex8() {
        // Ref int v;new(v,20);print(rH(v)); wH(v,30);print(rH(v)+5);
        return
                new CompStatement(
                        new VarDeclStatement("v", new RefType(new IntType())),
                        new CompStatement(
                                new NewStatement("v", new ValueExpression(new IntValue(20))),
                                new CompStatement(
                                        new PrintStatement(new ReadHeapExpression(new VarExpression("v"))),
                                        new CompStatement(
                                                new HeapWritingStatement("v", new ValueExpression(new IntValue(30))),
                                                new PrintStatement(new ArithExpression(
                                                        new ReadHeapExpression(new VarExpression("v")),
                                                        new ValueExpression(new IntValue(5)),
                                                        '+'
                                                ))
                                        )
                                )
                        )
                );
    }

    private static IStatement ex9() {
        // Ref int v;new(v,20);Ref Ref int a; new(a,v);print(rH(v));print(rH(rH(a))+5)
        return
                new CompStatement(
                        new VarDeclStatement("v", new RefType(new IntType())),
                        new CompStatement(
                                new NewStatement("v", new ValueExpression(new IntValue(20))),
                                new CompStatement(
                                        new VarDeclStatement("a", new RefType(new RefType(new IntType()))),
                                        new CompStatement(
                                                //new NewStatement("a", new VarExpression("v")),
                                                new NewStatement("v", new ValueExpression(new IntValue(20))),                                                new CompStatement(
                                                        new PrintStatement(new ReadHeapExpression(new VarExpression("v"))),
                                                        new PrintStatement(new ArithExpression(
                                                                new ReadHeapExpression(new ReadHeapExpression(new VarExpression("a"))),
                                                                new ValueExpression(new IntValue(5)),
                                                                '+'
                                                        ))
                                                )
                                        )
                                )
                        )
                );
    }

    private static IStatement ex10() {
        // Ref int v; new(v,20); Ref Ref int a; new(a,v); print(v); print(a)
        return
                new CompStatement(
                        new VarDeclStatement("v", new RefType(new IntType())),
                        new CompStatement(
                                new NewStatement("v", new ValueExpression(new IntValue(20))),
                                new CompStatement(
                                        new VarDeclStatement("a", new RefType(new RefType(new IntType()))),
                                        new CompStatement(
                                                new NewStatement("a", new VarExpression("v")),
                                                new CompStatement(
                                                        new PrintStatement(new VarExpression("v")),
                                                        new PrintStatement(new VarExpression("a"))
                                                )
                                        )
                                )
                        )
                );
    }

    private static IStatement ex11() {
        // Ref int v; new(v,20); Ref Ref int a; new(a,v); new(v,30); print(rH(rH(a)))
        return
                new CompStatement(
                        new VarDeclStatement("v", new RefType(new IntType())),
                        new CompStatement(
                                new NewStatement("v", new ValueExpression(new IntValue(20))),
                                new CompStatement(
                                        new VarDeclStatement("a", new RefType(new RefType(new IntType()))),
                                        new CompStatement(
                                                new NewStatement("a", new VarExpression("v")),
                                                new CompStatement(
                                                        new NewStatement("v", new ValueExpression(new IntValue(30))),
                                                        new CompStatement(
                                                                new VarDeclStatement("V", new RefType(new IntType())),
                                                                new CompStatement(
                                                                new PrintStatement(new ReadHeapExpression(new ReadHeapExpression(new VarExpression("a")))),
                                                                        new AssignStatement("V", new ValueExpression(new IntValue(30))))
                                                        )
                                                )
                                        )
                                )
                        )
                );
    }

    private static IStatement ex12(){
        // int v; v=4; (while (v + 1) print(v);v=v-1);print(v)
        return
                new CompStatement(
                        new VarDeclStatement("v", new IntType()),
                        new CompStatement(
                                new AssignStatement("v", new ValueExpression(new IntValue(4))),
                                new CompStatement(
                                        new WhileStatement(
                                                new ArithExpression(
                                                        new VarExpression("v"),
                                                        new ValueExpression(new IntValue(0)),
                                                        '+'
                                                ),
                                                new CompStatement(
                                                        new PrintStatement(new VarExpression("v")),
                                                        new AssignStatement("v", new ArithExpression(
                                                                new VarExpression("v"),
                                                                new ValueExpression(new IntValue(1)),
                                                                '-'
                                                        )
                                                        )
                                                )),
                                        new PrintStatement(new VarExpression("v"))
                                )
                        )
                );
    }

    private static IStatement ex13(){
        // int v; Ref int a; v=10; new(a, 22);
        // {fork(wH(a,30)); v=32; print(v) print(rH(a));}
        // print(v); print(rH(a));

        return new CompStatement(
                new VarDeclStatement("v", new IntType()),
                new CompStatement(
                        new VarDeclStatement("a", new RefType(new IntType())),
                        new CompStatement(
                                new AssignStatement("v", new ValueExpression(new IntValue(10))),
                                new CompStatement(
                                        new NewStatement("a", new ValueExpression(new IntValue(22))),
                                        new CompStatement(
                                            new Fork(
                                                    new CompStatement(
                                                            new HeapWritingStatement("a", new ValueExpression(new IntValue(30))),
                                                            new CompStatement(
                                                                    new AssignStatement("v", new ValueExpression(new IntValue(32))),
                                                                    new CompStatement(
                                                                            new PrintStatement(new VarExpression("v")),
                                                                            new PrintStatement(new ReadHeapExpression(new VarExpression("a")))
                                                                    )
                                                            )
                                                    )
                                                ),
                                            new CompStatement(
                                                    new PrintStatement(new VarExpression("v")),
                                                    new PrintStatement(new ReadHeapExpression(new VarExpression("a")))
                                            )
                                        )
                                )
                        )
                )
        );
    }

    private static IStatement ex14(){
        // int v; Ref int a; v=10; new(a, 22);
        // {fork(wH(a,30)); v=32; print(v) print(rH(a));}
        // {fork (int k; k = 99; print (k));}
        // print(v); print(rH(a));

        return new CompStatement(
                new VarDeclStatement("v", new IntType()),
                new CompStatement(
                        new VarDeclStatement("a", new RefType(new IntType())),
                        new CompStatement(
                                new AssignStatement("v", new ValueExpression(new IntValue(10))),
                                new CompStatement(
                                        new NewStatement("a", new ValueExpression(new IntValue(22))),
                                        new CompStatement(
                                                new Fork(
                                                        new CompStatement(
                                                                new HeapWritingStatement("a", new ValueExpression(new IntValue(30))),
                                                                new CompStatement(
                                                                        new AssignStatement("v", new ValueExpression(new IntValue(32))),
                                                                        new CompStatement(
                                                                                new PrintStatement(new VarExpression("v")),
                                                                                new PrintStatement(new ReadHeapExpression(new VarExpression("a")))
                                                                        )
                                                                )
                                                        )
                                                ),
                                                new CompStatement(
                                                        new Fork(new CompStatement(
                                                                new VarDeclStatement("k", new IntType()),
                                                                new CompStatement(
                                                                        new AssignStatement("k", new ValueExpression(new IntValue(99))),
                                                                        new PrintStatement(new VarExpression("k"))
                                                                )
                                                        )),
                                                        new CompStatement(
                                                        new PrintStatement(new VarExpression("v")),
                                                        new PrintStatement(new ReadHeapExpression(new VarExpression("a")))
                                                        )
                                                )
                                        )
                                )
                        )
                )
        );
    }

    private static IStatement ex15(){
        //correct typecheker example
        return new CompStatement(
                new VarDeclStatement("v", new IntType()),
                new CompStatement (
                        new AssignStatement("v", new ValueExpression(new IntValue(2))),
                        new PrintStatement(new VarExpression("v"))));
    }

    private static IStatement ex16(){
        //error typecheker example
        return new CompStatement(
                new VarDeclStatement("v", new IntType()),
                new CompStatement (
                        new AssignStatement("v", new ValueExpression(new BoolValue(true))),
                        new PrintStatement(new VarExpression("v"))));
    }

    private static IStatement ex17(){
        return concatStatements(
                new VarDeclStatement("v", new IntType()),
                new AssignStatement("v", new ValueExpression(new IntValue(0))),
                new RepeatUntilStatement(
                        new RelationalExpression(
                                new VarExpression("v"),
                                new ValueExpression(new IntValue(3)),
                                "=="),
                        concatStatements(
                                new Fork(
                                        concatStatements(
                                                new PrintStatement(new VarExpression("v")),
                                                new AssignStatement("v",
                                                        new ArithExpression(
                                                                new VarExpression("v"),
                                                                new ValueExpression(new IntValue(1)),
                                                                '-'))
                                                )),
                                new AssignStatement(
                                        "v",
                                        new ArithExpression(
                                                new VarExpression("v"),
                                                new ValueExpression(new IntValue(1)),
                                                '+'
                                        )
                                )

                        )
                ),
                new NopStatement(),
                new NopStatement(),
                new NopStatement(),
                new NopStatement(),
                new PrintStatement(new ArithExpression(
                        new VarExpression("v"),
                        new ValueExpression(new IntValue(10)),
                        '*'))
        );

    }

    private static IStatement ex18() {
        return concatStatements(
                new VarDeclStatement("v1", new RefType(new IntType())),
                new VarDeclStatement("v2", new RefType(new IntType())),
                new VarDeclStatement("v3", new RefType(new IntType())),
                new VarDeclStatement("cnt", new IntType()),
                new NewStatement("v1", new ValueExpression(new IntValue(2))),
                new NewStatement("v2", new ValueExpression(new IntValue(3))),
                new NewStatement("v3", new ValueExpression(new IntValue(4))),
                new NewLatchStatement("cnt", new ReadHeapExpression(new VarExpression("v2"))),
                new Fork(concatStatements(
                        new HeapWritingStatement("v1", new ArithExpression(
                                new ReadHeapExpression(new VarExpression("v1")),
                                new ValueExpression(new IntValue(10)),
                                '*')
                        ),
                        new PrintStatement(new ReadHeapExpression(new VarExpression("v1"))),
                        new CountDownStatement("cnt")
                )),
                new Fork(concatStatements(
                        new HeapWritingStatement("v2", new ArithExpression(
                                new ReadHeapExpression(new VarExpression("v2")),
                                new ValueExpression(new IntValue(10)),
                                '*')
                        ),
                        new PrintStatement(new ReadHeapExpression(new VarExpression("v2"))),
                        new CountDownStatement("cnt")
                )),
                new Fork(concatStatements(
                        new HeapWritingStatement("v3", new ArithExpression(
                                new ReadHeapExpression(new VarExpression("v3")),
                                new ValueExpression(new IntValue(10)),
                                '*')
                        ),
                        new PrintStatement(new ReadHeapExpression(new VarExpression("v3"))),
                        new CountDownStatement("cnt")
                )),
                new AwaitStatement("cnt"),
                new PrintStatement(new ValueExpression(new IntValue(100))),
                new CountDownStatement("cnt"),
                new PrintStatement(new ValueExpression(new IntValue(100)))
        );
    }

    private static IStatement ex19(){
        return concatStatements(
                new VarDeclStatement("v1", new RefType(new IntType())),
                new VarDeclStatement("v2", new RefType(new IntType())),
                new VarDeclStatement("v3", new RefType(new IntType())),
                new NewStatement("v1", new ValueExpression(new IntValue(2))),
                new NewStatement("v2", new ValueExpression(new IntValue(3))),
                new NewStatement("v3", new ValueExpression(new IntValue(4))),
                new NewLatchStatement("cnt", new ReadHeapExpression(new VarExpression("v2"))),
                new Fork(
                        concatStatements(
                                new HeapWritingStatement(
                                        "v1",
                                        new ArithExpression(
                                                new ReadHeapExpression(
                                                        new VarExpression("v1")
                                                ),
                                                new ValueExpression(
                                                        new IntValue(10)
                                                ),
                                                '*'
                                        )
                                ),
                                new PrintStatement(
                                        new ReadHeapExpression(new VarExpression("v1"))
                                ),
                                new CountDownStatement(
                                        "cnt"
                                ),
                                new Fork(
                                        concatStatements(
                                                new HeapWritingStatement(
                                                        "v2",
                                                        new ArithExpression(
                                                                new ReadHeapExpression(
                                                                        new VarExpression("v2")
                                                                ),
                                                                new ValueExpression(
                                                                        new IntValue(10)
                                                                ),
                                                                '*'
                                                        )
                                                ),
                                                new PrintStatement(
                                                        new ReadHeapExpression(new VarExpression("v2"))
                                                ),
                                                new CountDownStatement(
                                                        "cnt"
                                                ),
                                                new Fork(
                                                        concatStatements(
                                                                new HeapWritingStatement(
                                                                        "v3",
                                                                        new ArithExpression(
                                                                                new ReadHeapExpression(
                                                                                        new VarExpression("v3")
                                                                                ),
                                                                                new ValueExpression(
                                                                                        new IntValue(10)
                                                                                ),
                                                                                '*'
                                                                        )
                                                                ),
                                                                new PrintStatement(
                                                                        new ReadHeapExpression(new VarExpression("v3"))
                                                                ),
                                                                new CountDownStatement(
                                                                        "cnt"
                                                                )

                                                        )
                                                )
                                        )
                                )
                        )
                ),
                new AwaitStatement("cnt"),
                new PrintStatement(new ValueExpression(new IntValue(100))),
                new CountDownStatement("cnt"),
                new PrintStatement(new ValueExpression(new IntValue(100)))
        );
    }

    private static IStatement ex20(){
        //aici iti scrii statementul pe care il vrei

        return new NopStatement();
    }

    private static IStatement concatStatements(IStatement... statements){
        if(statements.length == 1){
            return statements[0];
        }
        return new CompStatement(statements[0], concatStatements(Arrays.copyOfRange(statements, 1, statements.length)));
    }

    public static ArrayList<IStatement> getAll(){
        ArrayList<IStatement> statements = new ArrayList<>();
//        statements.add(main.ex1());
//        statements.add(main.ex2());
//        statements.add(main.ex3());
//        statements.add(main.ex4());
//        statements.add(main.ex5());
//        statements.add(main.ex6());
//        statements.add(main.ex7());
//        statements.add(main.ex8());
//        statements.add(main.ex9());
//        statements.add(main.ex10());
//        statements.add(main.ex11());
//        statements.add(main.ex12());
//        statements.add(main.ex13());
//        statements.add(main.ex14());
//        statements.add(main.ex15());
//        statements.add(main.ex17());
        statements.add(main.ex18());
        statements.add(main.ex20());


        return statements;
    }
}

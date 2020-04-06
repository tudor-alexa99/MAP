package Model;

import Model.ADT.*;
import Model.DataTypes.StringType;
import Model.Exceptions.MyException;
import Model.Statements.IStatement;
import Model.Values.StringValue;
import Model.Values.Value;

import java.io.BufferedReader;
import java.nio.charset.IllegalCharsetNameException;

public class ProgramState {
    private MyIStack<IStatement> exeStack;
    private MyIDictionary<String, Value> symTable;
    private MyIList<Value> out;
    private MyIDictionary<StringValue, BufferedReader> fileTable;
    private MyIHeap<Integer, Value> heap;
    private static int currentId = 0;
    private int id;
    private ILatchTable latchTable;

    public ProgramState(MyIStack<IStatement> stk, MyIDictionary<String, Value> symtbl,MyIList<Value> ot,  MyIDictionary<StringValue, BufferedReader> ftb,IStatement program, MyIHeap<Integer, Value> hp, ILatchTable ltb){
        exeStack=stk;
        symTable=symtbl;
        out = ot;
        this.fileTable = ftb;
        this.heap = hp;
        this.exeStack.push(program);
        this.latchTable = ltb;
        this.id = 0;
    }

    public MyIStack<IStatement> getExeStack() {
        return exeStack;
    }

    public void setExeStack(MyIStack<IStatement> exeStack) {
        this.exeStack = exeStack;
    }

    public MyIDictionary<String, Value> getSymTable() {
        return symTable;
    }

    public void setSymTable(MyIDictionary<String, Value> symTable) {
        this.symTable = symTable;
    }

    public MyIList<Value> getOut() {
        return out;
    }

    public void setOut(MyIList<Value> out) {
        this.out = out;
    }

    public MyIDictionary<StringValue, BufferedReader> getFileTable(){ return this.fileTable; }

    public void setFileTable(MyIDictionary<StringValue, BufferedReader>_ft){this.fileTable = _ft; }

    public MyIHeap<Integer, Value> getHeap() {return this.heap;}

    public void setHeap(MyIHeap<Integer, Value> _heap) { this.heap = _heap; }

    public synchronized void setNewId(){
        currentId ++;
        this.id = currentId;
    }

    public Boolean isNotCompleted(){
        return !this.exeStack.isEmpty();
    }

    public ProgramState oneStep() throws MyException {
        if (exeStack.isEmpty())
            throw new MyException("Program state stack is empty");
        IStatement currentStatement = exeStack.pop();
        return currentStatement.execute(this);
    }

    @Override
    public String toString() {
        return "[" + this.id + "]" + "ExeStack: " + this.exeStack.toString() + "\n" +
                "[" + this.id + "]" + "Symbol table: " + this.symTable + "\n" +
                "[" + this.id + "]" + "Out list:: " + this.out + "\n" +
                "[" + this.id + "]" + "Heap: " + this.heap.toString();
    }

    public ILatchTable getLatchTable() {
        return latchTable;
    }

    public Integer getThreadId(){ return this.id; }

}

package Model.Statements;

import Model.ADT.MyIDictionary;
import Model.ADT.MyIHeap;
import Model.DataTypes.Type;
import Model.Exceptions.MyException;
import Model.Expressions.Expression;
import Model.ProgramState;
import Model.Values.Value;

public class AssignStatement implements IStatement {
    private String name;
    private Expression expr;

    public AssignStatement(String _name, Expression _expr) {
        this.name = _name;
        this.expr = _expr;
    }

    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        MyIDictionary<String, Value>  symTable = state.getSymTable();
        MyIHeap<Integer, Value> heap = state.getHeap();
        if(! symTable.isDefined(this.name))
            throw new MyException("Variable not defined! ");
        else{
            Value val = this.expr.eval(symTable, heap);
            Type nameType = symTable.getValue(this.name).getType();
            if(!nameType.equals(val.getType()))
                throw new MyException("Invalid data type!");
            else{
                symTable.update(this.name, val);
            }
        }
//        return state;
        return null;
    }

    @Override
    public String toString() {
        return this.name + "=" + this.expr;
    }

    @Override
    public MyIDictionary<String, Type> typecheck(MyIDictionary<String, Type> typeEnv) throws MyException {
        Type typeVar = typeEnv.getValue(this.name);
        Type typeExp = this.expr.typecheck(typeEnv);

        if(! typeVar.equals(typeExp))
            throw new MyException("TypeCheck error: left and right operands have different types!");
        return typeEnv;
    }
}

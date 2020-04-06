package Model.Statements;

import Model.ADT.MyIDictionary;
import Model.DataTypes.Type;
import Model.Exceptions.MyException;
import Model.Expressions.Expression;
import Model.ProgramState;

public class ConditionalAssignment implements IStatement {
    private String v;
    private Expression exp1;
    private Expression exp2;
    private Expression exp3;

    public ConditionalAssignment(String v, Expression exp1, Expression exp2, Expression exp3) {
        this.v = v;
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.exp3 = exp3;
    }

    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        IStatement stm = new IfStatement(
                exp1,
                new AssignStatement(
                        "v",
                        exp2
                ),
                new AssignStatement(
                        "v",
                        exp3
                )
        );
        state.getExeStack().push(stm);
        return null;
    }

    @Override
    public MyIDictionary<String, Type> typecheck(MyIDictionary<String, Type> typeEnv) throws MyException {
        return typeEnv; //aici zice ca nu trebuie adaptat typecheckerul pentru asta

    }
}

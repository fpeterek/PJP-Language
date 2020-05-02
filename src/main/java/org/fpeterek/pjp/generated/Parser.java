/* Parser.java */
/* Generated By:JJTree&JavaCC: Do not edit this line. Parser.java */
package org.fpeterek.pjp.generated;

public class Parser/*@bgen(jjtree)*/implements ParserTreeConstants, ParserConstants {/*@bgen(jjtree)*/
  protected JJTParserState jjtree = new JJTParserState();public static void main(String[] args) throws ParseException {
    Parser parser = new Parser(System.in);
    parser.Start().dump("");
  }

  final public ASTStart Start() throws ParseException {/*@bgen(jjtree) Start */
  ASTStart jjtn000 = new ASTStart(JJTSTART);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      label_1:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case IF:
        case VAR:
        case WRITE:
        case READ:
        case FOR:
        case TERMINATOR:
        case INTEGER_LITERAL:
        case FLOAT_LITERAL:
        case BOOL_LITERAL:
        case STRING_LITERAL:
        case BANG:
        case MINUS:
        case IDENTIFIER:
        case 49:{
          ;
          break;
          }
        default:
          jj_la1[0] = jj_gen;
          break label_1;
        }
        Statement();
      }
      jj_consume_token(0);
jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
{if ("" != null) return jjtn000;}
    } catch (Throwable jjte000) {
if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
    throw new Error("Missing return statement in function");
}

  final public void Statement() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case TERMINATOR:{
      jj_consume_token(TERMINATOR);
      break;
      }
    case VAR:{
      Var();
      break;
      }
    case READ:{
ASTRead jjtn001 = new ASTRead(JJTREAD);
    boolean jjtc001 = true;
    jjtree.openNodeScope(jjtn001);
      try {
        jj_consume_token(READ);
        Identifier();
        label_2:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
          case 48:{
            ;
            break;
            }
          default:
            jj_la1[1] = jj_gen;
            break label_2;
          }
          jj_consume_token(48);
          Identifier();
        }
        jj_consume_token(TERMINATOR);
      } catch (Throwable jjte001) {
if (jjtc001) {
      jjtree.clearNodeScope(jjtn001);
      jjtc001 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte001 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte001;}
    }
    if (jjte001 instanceof ParseException) {
      {if (true) throw (ParseException)jjte001;}
    }
    {if (true) throw (Error)jjte001;}
      } finally {
if (jjtc001) {
      jjtree.closeNodeScope(jjtn001, true);
    }
      }
      break;
      }
    case WRITE:{
ASTWrite jjtn002 = new ASTWrite(JJTWRITE);
    boolean jjtc002 = true;
    jjtree.openNodeScope(jjtn002);
      try {
        jj_consume_token(WRITE);
        Expression();
        label_3:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
          case 48:{
            ;
            break;
            }
          default:
            jj_la1[2] = jj_gen;
            break label_3;
          }
          jj_consume_token(48);
          Expression();
        }
        jj_consume_token(TERMINATOR);
      } catch (Throwable jjte002) {
if (jjtc002) {
      jjtree.clearNodeScope(jjtn002);
      jjtc002 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte002 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte002;}
    }
    if (jjte002 instanceof ParseException) {
      {if (true) throw (ParseException)jjte002;}
    }
    {if (true) throw (Error)jjte002;}
      } finally {
if (jjtc002) {
      jjtree.closeNodeScope(jjtn002, true);
    }
      }
      break;
      }
    case INTEGER_LITERAL:
    case FLOAT_LITERAL:
    case BOOL_LITERAL:
    case STRING_LITERAL:
    case BANG:
    case MINUS:
    case IDENTIFIER:
    case 49:{
      Expression();
      jj_consume_token(TERMINATOR);
      break;
      }
    case IF:
    case FOR:{
      ControlFlow();
      break;
      }
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

  final public void Var() throws ParseException {/*@bgen(jjtree) Var */
  ASTVar jjtn000 = new ASTVar(JJTVAR);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);Token t;
    try {
      jj_consume_token(VAR);
      Identifier();
      label_4:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case 48:{
          ;
          break;
          }
        default:
          jj_la1[4] = jj_gen;
          break label_4;
        }
        jj_consume_token(48);
        Identifier();
      }
      jj_consume_token(COLON);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case INT:{
        t = jj_consume_token(INT);
jjtn000.value = t.image;
        break;
        }
      case BOOL:{
        t = jj_consume_token(BOOL);
jjtn000.value = t.image;
        break;
        }
      case FLOAT:{
        t = jj_consume_token(FLOAT);
jjtn000.value = t.image;
        break;
        }
      case STRING:{
        t = jj_consume_token(STRING);
jjtn000.value = t.image;
        break;
        }
      default:
        jj_la1[5] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(TERMINATOR);
    } catch (Throwable jjte000) {
if (jjtc000) {
       jjtree.clearNodeScope(jjtn000);
       jjtc000 = false;
     } else {
       jjtree.popNode();
     }
     if (jjte000 instanceof RuntimeException) {
       {if (true) throw (RuntimeException)jjte000;}
     }
     if (jjte000 instanceof ParseException) {
       {if (true) throw (ParseException)jjte000;}
     }
     {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
       jjtree.closeNodeScope(jjtn000, true);
     }
    }
}

  final public void ControlFlow() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case IF:{
      If();
      break;
      }
    case FOR:{
      For();
      break;
      }
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

  final public void For() throws ParseException {/*@bgen(jjtree) For */
  ASTFor jjtn000 = new ASTFor(JJTFOR);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(FOR);
      jj_consume_token(49);
      Expression();
      jj_consume_token(TERMINATOR);
      Expression();
      jj_consume_token(TERMINATOR);
      Expression();
      jj_consume_token(50);
      StatementBlock();
    } catch (Throwable jjte000) {
if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
}

  final public void If() throws ParseException {/*@bgen(jjtree) If */
  ASTIf jjtn000 = new ASTIf(JJTIF);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(IF);
      BracedExpression();
      StatementBlock();
      if (jj_2_1(2)) {
        jj_consume_token(ELSE);
        StatementBlock();
      } else {
        ;
      }
    } catch (Throwable jjte000) {
if (jjtc000) {
     jjtree.clearNodeScope(jjtn000);
     jjtc000 = false;
   } else {
     jjtree.popNode();
   }
   if (jjte000 instanceof RuntimeException) {
     {if (true) throw (RuntimeException)jjte000;}
   }
   if (jjte000 instanceof ParseException) {
     {if (true) throw (ParseException)jjte000;}
   }
   {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
     jjtree.closeNodeScope(jjtn000, true);
   }
    }
}

  final public void StatementBlock() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case IF:
    case VAR:
    case WRITE:
    case READ:
    case FOR:
    case TERMINATOR:
    case INTEGER_LITERAL:
    case FLOAT_LITERAL:
    case BOOL_LITERAL:
    case STRING_LITERAL:
    case BANG:
    case MINUS:
    case IDENTIFIER:
    case 49:{
      Statement();
      break;
      }
    case LEFT_BRACE:{
ASTBlock jjtn001 = new ASTBlock(JJTBLOCK);
    boolean jjtc001 = true;
    jjtree.openNodeScope(jjtn001);
      try {
        jj_consume_token(LEFT_BRACE);
        label_5:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
          case IF:
          case VAR:
          case WRITE:
          case READ:
          case FOR:
          case TERMINATOR:
          case INTEGER_LITERAL:
          case FLOAT_LITERAL:
          case BOOL_LITERAL:
          case STRING_LITERAL:
          case BANG:
          case MINUS:
          case IDENTIFIER:
          case 49:{
            ;
            break;
            }
          default:
            jj_la1[7] = jj_gen;
            break label_5;
          }
          Statement();
        }
        jj_consume_token(RIGHT_BRACE);
      } catch (Throwable jjte001) {
if (jjtc001) {
      jjtree.clearNodeScope(jjtn001);
      jjtc001 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte001 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte001;}
    }
    if (jjte001 instanceof ParseException) {
      {if (true) throw (ParseException)jjte001;}
    }
    {if (true) throw (Error)jjte001;}
      } finally {
if (jjtc001) {
      jjtree.closeNodeScope(jjtn001, true);
    }
      }
      break;
      }
    default:
      jj_la1[8] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

  final public void Expression() throws ParseException {
    TernaryOperator();
}

  final public void BracedExpression() throws ParseException {
    jj_consume_token(49);
    TernaryOperator();
    jj_consume_token(50);
}

  final public void TernaryOperator() throws ParseException {
ASTTernary jjtn001 = new ASTTernary(JJTTERNARY);
    boolean jjtc001 = true;
    jjtree.openNodeScope(jjtn001);
    try {
      BinaryOperator();
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case HOOK:{
        jj_consume_token(HOOK);
        BinaryOperator();
        jj_consume_token(COLON);
        BinaryOperator();
        break;
        }
      default:
        jj_la1[9] = jj_gen;
        ;
      }
    } catch (Throwable jjte001) {
if (jjtc001) {
      jjtree.clearNodeScope(jjtn001);
      jjtc001 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte001 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte001;}
    }
    if (jjte001 instanceof ParseException) {
      {if (true) throw (ParseException)jjte001;}
    }
    {if (true) throw (Error)jjte001;}
    } finally {
if (jjtc001) {
      jjtree.closeNodeScope(jjtn001, jjtree.nodeArity() > 1);
    }
    }
}

  final public void BinaryOperator() throws ParseException {
    if (jj_2_2(2147483647)) {
      Assignment();
    } else {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case INTEGER_LITERAL:
      case FLOAT_LITERAL:
      case BOOL_LITERAL:
      case STRING_LITERAL:
      case BANG:
      case MINUS:
      case IDENTIFIER:
      case 49:{
        OrExpression();
        break;
        }
      default:
        jj_la1[10] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
}

  final public void Assignment() throws ParseException {/*@bgen(jjtree) Assignment */
ASTAssignment jjtn000 = new ASTAssignment(JJTASSIGNMENT);
boolean jjtc000 = true;
jjtree.openNodeScope(jjtn000);Token t;
    try {
      Identifier();
      t = jj_consume_token(ASSIGN);
jjtn000.value = t.image;
      OrExpression();
    } catch (Throwable jjte000) {
if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
}

  final public void OrExpression() throws ParseException {
ASTOr jjtn001 = new ASTOr(JJTOR);
    boolean jjtc001 = true;
    jjtree.openNodeScope(jjtn001);
    try {
      AndExpression();
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case OR:{
        jj_consume_token(OR);
        OrExpression();
        break;
        }
      default:
        jj_la1[11] = jj_gen;
        ;
      }
    } catch (Throwable jjte001) {
if (jjtc001) {
      jjtree.clearNodeScope(jjtn001);
      jjtc001 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte001 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte001;}
    }
    if (jjte001 instanceof ParseException) {
      {if (true) throw (ParseException)jjte001;}
    }
    {if (true) throw (Error)jjte001;}
    } finally {
if (jjtc001) {
      jjtree.closeNodeScope(jjtn001, jjtree.nodeArity() > 1);
    }
    }
}

  final public void AndExpression() throws ParseException {
ASTAnd jjtn001 = new ASTAnd(JJTAND);
    boolean jjtc001 = true;
    jjtree.openNodeScope(jjtn001);
    try {
      Comparison();
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case AND:{
        jj_consume_token(AND);
        AndExpression();
        break;
        }
      default:
        jj_la1[12] = jj_gen;
        ;
      }
    } catch (Throwable jjte001) {
if (jjtc001) {
      jjtree.clearNodeScope(jjtn001);
      jjtc001 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte001 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte001;}
    }
    if (jjte001 instanceof ParseException) {
      {if (true) throw (ParseException)jjte001;}
    }
    {if (true) throw (Error)jjte001;}
    } finally {
if (jjtc001) {
      jjtree.closeNodeScope(jjtn001, jjtree.nodeArity() > 1);
    }
    }
}

  final public void Comparison() throws ParseException {Token t;
ASTCmp jjtn001 = new ASTCmp(JJTCMP);
    boolean jjtc001 = true;
    jjtree.openNodeScope(jjtn001);
    try {
      Addition();
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case GT:
      case LT:
      case EQ:
      case LTE:
      case GTE:
      case NEQ:{
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case GT:{
          t = jj_consume_token(GT);
jjtn001.value = t.image;
          break;
          }
        case GTE:{
          t = jj_consume_token(GTE);
jjtn001.value = t.image;
          break;
          }
        case LT:{
          t = jj_consume_token(LT);
jjtn001.value = t.image;
          break;
          }
        case LTE:{
          t = jj_consume_token(LTE);
jjtn001.value = t.image;
          break;
          }
        case EQ:{
          t = jj_consume_token(EQ);
jjtn001.value = t.image;
          break;
          }
        case NEQ:{
          t = jj_consume_token(NEQ);
jjtn001.value = t.image;
          break;
          }
        default:
          jj_la1[13] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        Addition();
        break;
        }
      default:
        jj_la1[14] = jj_gen;
        ;
      }
    } catch (Throwable jjte001) {
if (jjtc001) {
      jjtree.clearNodeScope(jjtn001);
      jjtc001 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte001 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte001;}
    }
    if (jjte001 instanceof ParseException) {
      {if (true) throw (ParseException)jjte001;}
    }
    {if (true) throw (Error)jjte001;}
    } finally {
if (jjtc001) {
      jjtree.closeNodeScope(jjtn001, jjtree.nodeArity() > 1);
    }
    }
}

  final public void Addition() throws ParseException {Token t;
ASTAdd jjtn001 = new ASTAdd(JJTADD);
    boolean jjtc001 = true;
    jjtree.openNodeScope(jjtn001);
    try {
      Multiplication();
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case PLUS:
      case MINUS:
      case PERIOD:{
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case PLUS:{
          t = jj_consume_token(PLUS);
jjtn001.value = t.image;
          break;
          }
        case MINUS:{
          t = jj_consume_token(MINUS);
jjtn001.value = t.image;
          break;
          }
        case PERIOD:{
          t = jj_consume_token(PERIOD);
jjtn001.value = t.image;
          break;
          }
        default:
          jj_la1[15] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        Addition();
        break;
        }
      default:
        jj_la1[16] = jj_gen;
        ;
      }
    } catch (Throwable jjte001) {
if (jjtc001) {
      jjtree.clearNodeScope(jjtn001);
      jjtc001 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte001 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte001;}
    }
    if (jjte001 instanceof ParseException) {
      {if (true) throw (ParseException)jjte001;}
    }
    {if (true) throw (Error)jjte001;}
    } finally {
if (jjtc001) {
      jjtree.closeNodeScope(jjtn001, jjtree.nodeArity() > 1);
    }
    }
}

  final public void Multiplication() throws ParseException {Token t;
ASTMult jjtn001 = new ASTMult(JJTMULT);
    boolean jjtc001 = true;
    jjtree.openNodeScope(jjtn001);
    try {
      UnaryOperator();
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case STAR:
      case SLASH:
      case REM:{
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case STAR:{
          t = jj_consume_token(STAR);
jjtn001.value = t.image;
          break;
          }
        case REM:{
          t = jj_consume_token(REM);
jjtn001.value = t.image;
          break;
          }
        case SLASH:{
          t = jj_consume_token(SLASH);
jjtn001.value = t.image;
          break;
          }
        default:
          jj_la1[17] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        Multiplication();
        break;
        }
      default:
        jj_la1[18] = jj_gen;
        ;
      }
    } catch (Throwable jjte001) {
if (jjtc001) {
      jjtree.clearNodeScope(jjtn001);
      jjtc001 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte001 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte001;}
    }
    if (jjte001 instanceof ParseException) {
      {if (true) throw (ParseException)jjte001;}
    }
    {if (true) throw (Error)jjte001;}
    } finally {
if (jjtc001) {
      jjtree.closeNodeScope(jjtn001, jjtree.nodeArity() > 1);
    }
    }
}

  final public void UnaryOperator() throws ParseException {Token t;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case BANG:
    case MINUS:{
ASTUnaryOp jjtn001 = new ASTUnaryOp(JJTUNARYOP);
    boolean jjtc001 = true;
    jjtree.openNodeScope(jjtn001);
      try {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case MINUS:{
          t = jj_consume_token(MINUS);
jjtn001.value = t.image;
          break;
          }
        case BANG:{
          t = jj_consume_token(BANG);
jjtn001.value = t.image;
          break;
          }
        default:
          jj_la1[19] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        UnaryOperator();
      } catch (Throwable jjte001) {
if (jjtc001) {
      jjtree.clearNodeScope(jjtn001);
      jjtc001 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte001 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte001;}
    }
    if (jjte001 instanceof ParseException) {
      {if (true) throw (ParseException)jjte001;}
    }
    {if (true) throw (Error)jjte001;}
      } finally {
if (jjtc001) {
      jjtree.closeNodeScope(jjtn001, true);
    }
      }
      break;
      }
    case INTEGER_LITERAL:
    case FLOAT_LITERAL:
    case BOOL_LITERAL:
    case STRING_LITERAL:
    case IDENTIFIER:
    case 49:{
      Value();
      break;
      }
    default:
      jj_la1[20] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

  final public void Value() throws ParseException {Token t;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case IDENTIFIER:{
      Identifier();
      break;
      }
    case INTEGER_LITERAL:
    case FLOAT_LITERAL:
    case BOOL_LITERAL:
    case STRING_LITERAL:{
      Literal();
      break;
      }
    case 49:{
      BracedExpression();
      break;
      }
    default:
      jj_la1[21] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

  final public void Identifier() throws ParseException {/*@bgen(jjtree) Identifier */
  ASTIdentifier jjtn000 = new ASTIdentifier(JJTIDENTIFIER);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);Token t;
    try {
      t = jj_consume_token(IDENTIFIER);
jjtree.closeNodeScope(jjtn000, true);
                     jjtc000 = false;
jjtn000.value = t.image;
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
}

  final public void Literal() throws ParseException {Token t;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case STRING_LITERAL:{
      t = jj_consume_token(STRING_LITERAL);
ASTStringLiteral jjtn001 = new ASTStringLiteral(JJTSTRINGLITERAL);
                        boolean jjtc001 = true;
                        jjtree.openNodeScope(jjtn001);
      try {
jjtree.closeNodeScope(jjtn001, true);
                        jjtc001 = false;
jjtn001.value = t.image;
      } finally {
if (jjtc001) {
                          jjtree.closeNodeScope(jjtn001, true);
                        }
      }
      break;
      }
    case FLOAT_LITERAL:{
      t = jj_consume_token(FLOAT_LITERAL);
ASTFloatLiteral jjtn002 = new ASTFloatLiteral(JJTFLOATLITERAL);
                        boolean jjtc002 = true;
                        jjtree.openNodeScope(jjtn002);
      try {
jjtree.closeNodeScope(jjtn002, true);
                        jjtc002 = false;
jjtn002.value = t.image;
      } finally {
if (jjtc002) {
                          jjtree.closeNodeScope(jjtn002, true);
                        }
      }
      break;
      }
    case INTEGER_LITERAL:{
      t = jj_consume_token(INTEGER_LITERAL);
ASTIntLiteral jjtn003 = new ASTIntLiteral(JJTINTLITERAL);
                        boolean jjtc003 = true;
                        jjtree.openNodeScope(jjtn003);
      try {
jjtree.closeNodeScope(jjtn003, true);
                        jjtc003 = false;
jjtn003.value = t.image;
      } finally {
if (jjtc003) {
                          jjtree.closeNodeScope(jjtn003, true);
                        }
      }
      break;
      }
    case BOOL_LITERAL:{
      t = jj_consume_token(BOOL_LITERAL);
ASTBoolLiteral jjtn004 = new ASTBoolLiteral(JJTBOOLLITERAL);
                        boolean jjtc004 = true;
                        jjtree.openNodeScope(jjtn004);
      try {
jjtree.closeNodeScope(jjtn004, true);
                        jjtc004 = false;
jjtn004.value = t.image;
      } finally {
if (jjtc004) {
                          jjtree.closeNodeScope(jjtn004, true);
                        }
      }
      break;
      }
    default:
      jj_la1[22] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

  private boolean jj_2_1(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_1()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_2_2(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_2()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  private boolean jj_3R_Expression_184_3_16()
 {
    if (jj_3R_TernaryOperator_196_3_18()) return true;
    return false;
  }

  private boolean jj_3R_StatementBlock_179_3_8()
 {
    if (jj_scan_token(LEFT_BRACE)) return true;
    return false;
  }

  private boolean jj_3R_StatementBlock_177_3_6()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (!jj_3R_StatementBlock_177_3_7()) return false;
    jj_scanpos = xsp;
    if (jj_3R_StatementBlock_179_3_8()) return true;
    return false;
  }

  private boolean jj_3R_StatementBlock_177_3_7()
 {
    if (jj_3R_Statement_132_3_9()) return true;
    return false;
  }

  private boolean jj_3R_Multiplication_270_3_32()
 {
    if (jj_3R_UnaryOperator_287_3_33()) return true;
    return false;
  }

  private boolean jj_3R_If_171_2_22()
 {
    if (jj_scan_token(IF)) return true;
    return false;
  }

  private boolean jj_3R_For_165_3_23()
 {
    if (jj_scan_token(FOR)) return true;
    return false;
  }

  private boolean jj_3R_ControlFlow_159_3_20()
 {
    if (jj_3R_For_165_3_23()) return true;
    return false;
  }

  private boolean jj_3R_ControlFlow_158_3_19()
 {
    if (jj_3R_If_171_2_22()) return true;
    return false;
  }

  private boolean jj_3R_ControlFlow_158_3_17()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (!jj_3R_ControlFlow_158_3_19()) return false;
    jj_scanpos = xsp;
    if (jj_3R_ControlFlow_159_3_20()) return true;
    return false;
  }

  private boolean jj_3R_Addition_253_3_31()
 {
    if (jj_3R_Multiplication_270_3_32()) return true;
    return false;
  }

  private boolean jj_3R_BinaryOperator_202_51_25()
 {
    if (jj_3R_OrExpression_218_3_27()) return true;
    return false;
  }

  private boolean jj_3R_Var_145_4_15()
 {
    if (jj_scan_token(VAR)) return true;
    return false;
  }

  private boolean jj_3R_Comparison_232_3_30()
 {
    if (jj_3R_Addition_253_3_31()) return true;
    return false;
  }

  private boolean jj_3R_Statement_137_3_14()
 {
    if (jj_3R_ControlFlow_158_3_17()) return true;
    return false;
  }

  private boolean jj_3R_Statement_136_3_13()
 {
    if (jj_3R_Expression_184_3_16()) return true;
    return false;
  }

  private boolean jj_3R_Statement_136_3_12()
 {
    if (jj_scan_token(WRITE)) return true;
    return false;
  }

  private boolean jj_3R_Statement_135_3_11()
 {
    if (jj_scan_token(READ)) return true;
    return false;
  }

  private boolean jj_3R_Statement_133_3_10()
 {
    if (jj_3R_Var_145_4_15()) return true;
    return false;
  }

  private boolean jj_3R_Literal_322_3_47()
 {
    if (jj_scan_token(BOOL_LITERAL)) return true;
    return false;
  }

  private boolean jj_3R_Statement_132_3_9()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (!jj_scan_token(18)) return false;
    jj_scanpos = xsp;
    if (!jj_3R_Statement_133_3_10()) return false;
    jj_scanpos = xsp;
    if (!jj_3R_Statement_135_3_11()) return false;
    jj_scanpos = xsp;
    if (!jj_3R_Statement_136_3_12()) return false;
    jj_scanpos = xsp;
    if (!jj_3R_Statement_136_3_13()) return false;
    jj_scanpos = xsp;
    if (jj_3R_Statement_137_3_14()) return true;
    return false;
  }

  private boolean jj_3R_Literal_321_3_46()
 {
    if (jj_scan_token(INTEGER_LITERAL)) return true;
    return false;
  }

  private boolean jj_3R_Literal_320_3_45()
 {
    if (jj_scan_token(FLOAT_LITERAL)) return true;
    return false;
  }

  private boolean jj_3R_Literal_319_3_44()
 {
    if (jj_scan_token(STRING_LITERAL)) return true;
    return false;
  }

  private boolean jj_3R_Literal_319_3_42()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (!jj_3R_Literal_319_3_44()) return false;
    jj_scanpos = xsp;
    if (!jj_3R_Literal_320_3_45()) return false;
    jj_scanpos = xsp;
    if (!jj_3R_Literal_321_3_46()) return false;
    jj_scanpos = xsp;
    if (jj_3R_Literal_322_3_47()) return true;
    return false;
  }

  private boolean jj_3R_AndExpression_224_3_29()
 {
    if (jj_3R_Comparison_232_3_30()) return true;
    return false;
  }

  private boolean jj_3R_OrExpression_218_3_27()
 {
    if (jj_3R_AndExpression_224_3_29()) return true;
    return false;
  }

  private boolean jj_3R_Identifier_311_5_28()
 {
    if (jj_scan_token(IDENTIFIER)) return true;
    return false;
  }

  private boolean jj_3_1()
 {
    if (jj_scan_token(ELSE)) return true;
    if (jj_3R_StatementBlock_177_3_6()) return true;
    return false;
  }

  private boolean jj_3_2()
 {
    if (jj_scan_token(IDENTIFIER)) return true;
    if (jj_scan_token(ASSIGN)) return true;
    return false;
  }

  private boolean jj_3R_Assignment_210_3_26()
 {
    if (jj_3R_Identifier_311_5_28()) return true;
    return false;
  }

  private boolean jj_3R_Value_303_3_41()
 {
    if (jj_3R_BracedExpression_190_3_43()) return true;
    return false;
  }

  private boolean jj_3R_Value_302_3_40()
 {
    if (jj_3R_Literal_319_3_42()) return true;
    return false;
  }

  private boolean jj_3R_Value_301_3_39()
 {
    if (jj_3R_Identifier_311_5_28()) return true;
    return false;
  }

  private boolean jj_3R_Value_301_3_38()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (!jj_3R_Value_301_3_39()) return false;
    jj_scanpos = xsp;
    if (!jj_3R_Value_302_3_40()) return false;
    jj_scanpos = xsp;
    if (jj_3R_Value_303_3_41()) return true;
    return false;
  }

  private boolean jj_3R_BinaryOperator_202_3_21()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (!jj_3R_BinaryOperator_202_3_24()) return false;
    jj_scanpos = xsp;
    if (jj_3R_BinaryOperator_202_51_25()) return true;
    return false;
  }

  private boolean jj_3R_BinaryOperator_202_3_24()
 {
    if (jj_3R_Assignment_210_3_26()) return true;
    return false;
  }

  private boolean jj_3R_UnaryOperator_293_5_35()
 {
    if (jj_3R_Value_301_3_38()) return true;
    return false;
  }

  private boolean jj_3R_UnaryOperator_290_8_37()
 {
    if (jj_scan_token(BANG)) return true;
    return false;
  }

  private boolean jj_3R_UnaryOperator_289_8_36()
 {
    if (jj_scan_token(MINUS)) return true;
    return false;
  }

  private boolean jj_3R_TernaryOperator_196_3_18()
 {
    if (jj_3R_BinaryOperator_202_3_21()) return true;
    return false;
  }

  private boolean jj_3R_UnaryOperator_287_3_33()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (!jj_3R_UnaryOperator_287_3_34()) return false;
    jj_scanpos = xsp;
    if (jj_3R_UnaryOperator_293_5_35()) return true;
    return false;
  }

  private boolean jj_3R_UnaryOperator_287_3_34()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (!jj_3R_UnaryOperator_289_8_36()) return false;
    jj_scanpos = xsp;
    if (jj_3R_UnaryOperator_290_8_37()) return true;
    return false;
  }

  private boolean jj_3R_BracedExpression_190_3_43()
 {
    if (jj_scan_token(49)) return true;
    return false;
  }

  /** Generated Token Manager. */
  public ParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[23];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
	   jj_la1_init_0();
	   jj_la1_init_1();
	}
	private static void jj_la1_init_0() {
	   jj_la1_0 = new int[] {0x468fa800,0x0,0x0,0x468fa800,0x0,0x4700,0x20800,0x468fa800,0x468fa800,0x80000000,0x46880000,0x0,0x0,0x30000000,0x30000000,0x0,0x0,0x0,0x0,0x40000000,0x46880000,0x6880000,0x6880000,};
	}
	private static void jj_la1_init_1() {
	   jj_la1_1 = new int[] {0x28100,0x10000,0x10000,0x28100,0x10000,0x0,0x0,0x28100,0x2a100,0x0,0x28100,0x20,0x40,0x1e,0x1e,0x1180,0x1180,0xe00,0xe00,0x100,0x28100,0x28000,0x0,};
	}
  final private JJCalls[] jj_2_rtns = new JJCalls[2];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public Parser(java.io.InputStream stream) {
	  this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Parser(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source = new ParserTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 23; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
	  ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jjtree.reset();
	 jj_gen = 0;
	 for (int i = 0; i < 23; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public Parser(java.io.Reader stream) {
	 jj_input_stream = new SimpleCharStream(stream, 1, 1);
	 token_source = new ParserTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 23; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
	if (jj_input_stream == null) {
	   jj_input_stream = new SimpleCharStream(stream, 1, 1);
	} else {
	   jj_input_stream.ReInit(stream, 1, 1);
	}
	if (token_source == null) {
 token_source = new ParserTokenManager(jj_input_stream);
	}

	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jjtree.reset();
	 jj_gen = 0;
	 for (int i = 0; i < 23; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public Parser(ParserTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 23; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(ParserTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jjtree.reset();
	 jj_gen = 0;
	 for (int i = 0; i < 23; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
	 Token oldToken;
	 if ((oldToken = token).next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 if (token.kind == kind) {
	   jj_gen++;
	   if (++jj_gc > 100) {
		 jj_gc = 0;
		 for (int i = 0; i < jj_2_rtns.length; i++) {
		   JJCalls c = jj_2_rtns[i];
		   while (c != null) {
			 if (c.gen < jj_gen) c.first = null;
			 c = c.next;
		   }
		 }
	   }
	   return token;
	 }
	 token = oldToken;
	 jj_kind = kind;
	 throw generateParseException();
  }

  @SuppressWarnings("serial")
  static private final class LookaheadSuccess extends java.lang.Error {
    @Override
    public Throwable fillInStackTrace() {
      return this;
    }
  }
  static private final LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
	 if (jj_scanpos == jj_lastpos) {
	   jj_la--;
	   if (jj_scanpos.next == null) {
		 jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
	   } else {
		 jj_lastpos = jj_scanpos = jj_scanpos.next;
	   }
	 } else {
	   jj_scanpos = jj_scanpos.next;
	 }
	 if (jj_rescan) {
	   int i = 0; Token tok = token;
	   while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
	   if (tok != null) jj_add_error_token(kind, i);
	 }
	 if (jj_scanpos.kind != kind) return true;
	 if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
	 return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
	 if (token.next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 jj_gen++;
	 return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
	 Token t = token;
	 for (int i = 0; i < index; i++) {
	   if (t.next != null) t = t.next;
	   else t = t.next = token_source.getNextToken();
	 }
	 return t;
  }

  private int jj_ntk_f() {
	 if ((jj_nt=token.next) == null)
	   return (jj_ntk = (token.next=token_source.getNextToken()).kind);
	 else
	   return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
	 if (pos >= 100) {
		return;
	 }

	 if (pos == jj_endpos + 1) {
	   jj_lasttokens[jj_endpos++] = kind;
	 } else if (jj_endpos != 0) {
	   jj_expentry = new int[jj_endpos];

	   for (int i = 0; i < jj_endpos; i++) {
		 jj_expentry[i] = jj_lasttokens[i];
	   }

	   for (int[] oldentry : jj_expentries) {
		 if (oldentry.length == jj_expentry.length) {
		   boolean isMatched = true;

		   for (int i = 0; i < jj_expentry.length; i++) {
			 if (oldentry[i] != jj_expentry[i]) {
			   isMatched = false;
			   break;
			 }

		   }
		   if (isMatched) {
			 jj_expentries.add(jj_expentry);
			 break;
		   }
		 }
	   }

	   if (pos != 0) {
		 jj_lasttokens[(jj_endpos = pos) - 1] = kind;
	   }
	 }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
	 jj_expentries.clear();
	 boolean[] la1tokens = new boolean[51];
	 if (jj_kind >= 0) {
	   la1tokens[jj_kind] = true;
	   jj_kind = -1;
	 }
	 for (int i = 0; i < 23; i++) {
	   if (jj_la1[i] == jj_gen) {
		 for (int j = 0; j < 32; j++) {
		   if ((jj_la1_0[i] & (1<<j)) != 0) {
			 la1tokens[j] = true;
		   }
		   if ((jj_la1_1[i] & (1<<j)) != 0) {
			 la1tokens[32+j] = true;
		   }
		 }
	   }
	 }
	 for (int i = 0; i < 51; i++) {
	   if (la1tokens[i]) {
		 jj_expentry = new int[1];
		 jj_expentry[0] = i;
		 jj_expentries.add(jj_expentry);
	   }
	 }
	 jj_endpos = 0;
	 jj_rescan_token();
	 jj_add_error_token(0, 0);
	 int[][] exptokseq = new int[jj_expentries.size()][];
	 for (int i = 0; i < jj_expentries.size(); i++) {
	   exptokseq[i] = jj_expentries.get(i);
	 }
	 return new ParseException(token, exptokseq, tokenImage);
  }

  private boolean trace_enabled;

/** Trace enabled. */
  final public boolean trace_enabled() {
	 return trace_enabled;
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
	 jj_rescan = true;
	 for (int i = 0; i < 2; i++) {
	   try {
		 JJCalls p = jj_2_rtns[i];

		 do {
		   if (p.gen > jj_gen) {
			 jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
			 switch (i) {
			   case 0: jj_3_1(); break;
			   case 1: jj_3_2(); break;
			 }
		   }
		   p = p.next;
		 } while (p != null);

		 } catch(LookaheadSuccess ls) { }
	 }
	 jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
	 JJCalls p = jj_2_rtns[index];
	 while (p.gen > jj_gen) {
	   if (p.next == null) { p = p.next = new JJCalls(); break; }
	   p = p.next;
	 }

	 p.gen = jj_gen + xla - jj_la; 
	 p.first = token;
	 p.arg = xla;
  }

  static final class JJCalls {
	 int gen;
	 Token first;
	 int arg;
	 JJCalls next;
  }

}

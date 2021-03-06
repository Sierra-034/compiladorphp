/* ComPHP.java */
/* Generated By:JavaCC: Do not edit this line. ComPHP.java */
package compilador;

import java.util.ArrayList;

public class ComPHP implements ComPHPConstants {
    //ArrayList para almacenar los tokens
    private static ArrayList<Token> listValues = new ArrayList<Token>();

/*
    Esta gramática se utiliza para 
    iniciar cualquier programa en PHP 
    es el punto inicial. La parte más 
    ímportante son los delimitadores. 
    El uso de la gramática instrucción 
    valida cualquier tipo de instrucción PHP.
*/
  final public void gramaticaPrincipal() throws ParseException {
    jj_consume_token(MENOR);
    jj_consume_token(QUERY);
    jj_consume_token(PHP);
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case IF:
      case SWITCH:
      case FOR:
      case WHILE:
      case DO:
      case BREAK:
      case CONTINUE:
      case FUNCTION:
      case ECHO:
      case INCREMENTO:
      case DECREMENTO:
      case ID_FUNCION:
      case IDENTIFICADOR:{
        ;
        break;
        }
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case IF:
      case SWITCH:
      case FOR:
      case WHILE:
      case DO:
      case BREAK:
      case CONTINUE:
      case ECHO:
      case INCREMENTO:
      case DECREMENTO:
      case ID_FUNCION:
      case IDENTIFICADOR:{
        instruccion();
        break;
        }
      case FUNCTION:{
        funcion();
        break;
        }
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    jj_consume_token(QUERY);
    jj_consume_token(MAYOR);
  }

/*
    Gramática función especifica cómo se deben 
    declarar las funciones
*/
  final public void funcion() throws ParseException {
    jj_consume_token(FUNCTION);
    jj_consume_token(ID_FUNCION);
    jj_consume_token(POP);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case IDENTIFICADOR:{
      jj_consume_token(IDENTIFICADOR);
      label_2:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case COM:{
          ;
          break;
          }
        default:
          jj_la1[2] = jj_gen;
          break label_2;
        }
        jj_consume_token(COM);
        jj_consume_token(IDENTIFICADOR);
      }
      break;
      }
    default:
      jj_la1[3] = jj_gen;
      ;
    }
    jj_consume_token(PCL);
    jj_consume_token(KOP);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case IF:
      case SWITCH:
      case FOR:
      case WHILE:
      case DO:
      case BREAK:
      case CONTINUE:
      case ECHO:
      case INCREMENTO:
      case DECREMENTO:
      case ID_FUNCION:
      case IDENTIFICADOR:{
        ;
        break;
        }
      default:
        jj_la1[4] = jj_gen;
        break label_3;
      }
      instruccion();
    }
    jj_consume_token(KCL);
  }

/*
    LLamada a una función
    después de que se declaran las 
    funciones, éstas pueden ser llamadas
    como lo indica esta grammática
*/
  final public void callFuncion() throws ParseException {
    jj_consume_token(ID_FUNCION);
    jj_consume_token(POP);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case IDENTIFICADOR:{
      jj_consume_token(IDENTIFICADOR);
      label_4:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case COM:{
          ;
          break;
          }
        default:
          jj_la1[5] = jj_gen;
          break label_4;
        }
        jj_consume_token(COM);
        jj_consume_token(IDENTIFICADOR);
      }
      break;
      }
    default:
      jj_la1[6] = jj_gen;
      ;
    }
    jj_consume_token(PCL);
  }

/*
    Una instrucción engloba todo aquello que 
    sirve para escribir un programa
    se dividieron en tres tipos principales
    las estructuras secuenciales, estructuras de
    control y las estructuras de repetición 
*/
  final public void instruccion() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case BREAK:
    case CONTINUE:
    case ECHO:
    case INCREMENTO:
    case DECREMENTO:
    case ID_FUNCION:
    case IDENTIFICADOR:{
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case INCREMENTO:
      case DECREMENTO:
      case IDENTIFICADOR:{
        declaracionAsignacion();
        break;
        }
      case ID_FUNCION:{
        callFuncion();
        break;
        }
      case ECHO:{
        printFuntion();
        break;
        }
      case BREAK:{
        jj_consume_token(BREAK);
        break;
        }
      case CONTINUE:{
        jj_consume_token(CONTINUE);
        break;
        }
      default:
        jj_la1[7] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(PC);
      break;
      }
    case IF:
    case SWITCH:
    case FOR:
    case WHILE:
    case DO:{
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case IF:
      case SWITCH:{
        control();
        break;
        }
      case FOR:
      case WHILE:
      case DO:{
        repeticion();
        break;
        }
      default:
        jj_la1[8] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
      }
    default:
      jj_la1[9] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void printFuntion() throws ParseException {
    jj_consume_token(ECHO);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case POP:
    case VALOR_INT:
    case VALOR_DOUBLE:
    case VALOR_BOOLEAN:
    case VALOR_STRING:
    case ID_FUNCION:
    case IDENTIFICADOR:{
      expresion();
      break;
      }
    default:
      jj_la1[10] = jj_gen;
      ;
    }
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case COM:{
        ;
        break;
        }
      default:
        jj_la1[11] = jj_gen;
        break label_5;
      }
      jj_consume_token(COM);
      expresion();
    }
  }

/*
    La estructuras de control sirven 
    para ejecutar o no cierta porción 
    de código dependiendo de alguna condición.

    Existen dos variantes de estas estructuras,
    La estructura IF y la SWITCH.
*/
  final public void control() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case IF:{
      jj_consume_token(IF);
      jj_consume_token(POP);
      expresion();
listValues.clear();
      jj_consume_token(PCL);
      jj_consume_token(KOP);
      label_6:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case IF:
        case SWITCH:
        case FOR:
        case WHILE:
        case DO:
        case BREAK:
        case CONTINUE:
        case FUNCTION:
        case ECHO:
        case INCREMENTO:
        case DECREMENTO:
        case ID_FUNCION:
        case IDENTIFICADOR:{
          ;
          break;
          }
        default:
          jj_la1[12] = jj_gen;
          break label_6;
        }
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case IF:
        case SWITCH:
        case FOR:
        case WHILE:
        case DO:
        case BREAK:
        case CONTINUE:
        case ECHO:
        case INCREMENTO:
        case DECREMENTO:
        case ID_FUNCION:
        case IDENTIFICADOR:{
          instruccion();
          break;
          }
        case FUNCTION:{
          funcion();
          break;
          }
        default:
          jj_la1[13] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
      jj_consume_token(KCL);
      label_7:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case ELSEIF:{
          ;
          break;
          }
        default:
          jj_la1[14] = jj_gen;
          break label_7;
        }
        jj_consume_token(ELSEIF);
        jj_consume_token(POP);
        expresion();
listValues.clear();
        jj_consume_token(PCL);
        jj_consume_token(KOP);
        label_8:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
          case IF:
          case SWITCH:
          case FOR:
          case WHILE:
          case DO:
          case BREAK:
          case CONTINUE:
          case FUNCTION:
          case ECHO:
          case INCREMENTO:
          case DECREMENTO:
          case ID_FUNCION:
          case IDENTIFICADOR:{
            ;
            break;
            }
          default:
            jj_la1[15] = jj_gen;
            break label_8;
          }
          switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
          case IF:
          case SWITCH:
          case FOR:
          case WHILE:
          case DO:
          case BREAK:
          case CONTINUE:
          case ECHO:
          case INCREMENTO:
          case DECREMENTO:
          case ID_FUNCION:
          case IDENTIFICADOR:{
            instruccion();
            break;
            }
          case FUNCTION:{
            funcion();
            break;
            }
          default:
            jj_la1[16] = jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
          }
        }
        jj_consume_token(KCL);
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case ELSE:{
        jj_consume_token(ELSE);
        jj_consume_token(KOP);
        label_9:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
          case IF:
          case SWITCH:
          case FOR:
          case WHILE:
          case DO:
          case BREAK:
          case CONTINUE:
          case FUNCTION:
          case ECHO:
          case INCREMENTO:
          case DECREMENTO:
          case ID_FUNCION:
          case IDENTIFICADOR:{
            ;
            break;
            }
          default:
            jj_la1[17] = jj_gen;
            break label_9;
          }
          switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
          case IF:
          case SWITCH:
          case FOR:
          case WHILE:
          case DO:
          case BREAK:
          case CONTINUE:
          case ECHO:
          case INCREMENTO:
          case DECREMENTO:
          case ID_FUNCION:
          case IDENTIFICADOR:{
            instruccion();
            break;
            }
          case FUNCTION:{
            funcion();
            break;
            }
          default:
            jj_la1[18] = jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
          }
        }
        jj_consume_token(KCL);
        break;
        }
      default:
        jj_la1[19] = jj_gen;
        ;
      }
      break;
      }
    case SWITCH:{
      jj_consume_token(SWITCH);
      jj_consume_token(KOP);
      expresion();
listValues.clear();
      jj_consume_token(PCL);
      jj_consume_token(KOP);
      label_10:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case CASE:{
          ;
          break;
          }
        default:
          jj_la1[20] = jj_gen;
          break label_10;
        }
        jj_consume_token(CASE);
        jj_consume_token(VALOR_INT);
        jj_consume_token(PP);
        label_11:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
          case IF:
          case SWITCH:
          case FOR:
          case WHILE:
          case DO:
          case BREAK:
          case CONTINUE:
          case ECHO:
          case INCREMENTO:
          case DECREMENTO:
          case ID_FUNCION:
          case IDENTIFICADOR:{
            ;
            break;
            }
          default:
            jj_la1[21] = jj_gen;
            break label_11;
          }
          instruccion();
        }
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case DEF:{
        jj_consume_token(DEF);
        jj_consume_token(PP);
        label_12:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
          case IF:
          case SWITCH:
          case FOR:
          case WHILE:
          case DO:
          case BREAK:
          case CONTINUE:
          case ECHO:
          case INCREMENTO:
          case DECREMENTO:
          case ID_FUNCION:
          case IDENTIFICADOR:{
            ;
            break;
            }
          default:
            jj_la1[22] = jj_gen;
            break label_12;
          }
          instruccion();
        }
        break;
        }
      default:
        jj_la1[23] = jj_gen;
        ;
      }
      jj_consume_token(KCL);
      break;
      }
    default:
      jj_la1[24] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/*
    Las estructuras de repetición permiten
    ejecutar o no un fragmento de código
    cero o varias veces dependiendo de una
    condición dada. Similar a las estructuras de control
*/
  final public void repeticion() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case WHILE:{
      jj_consume_token(WHILE);
      jj_consume_token(POP);
      expresion();
listValues.clear();
      jj_consume_token(PCL);
      jj_consume_token(KOP);
      label_13:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case IF:
        case SWITCH:
        case FOR:
        case WHILE:
        case DO:
        case BREAK:
        case CONTINUE:
        case ECHO:
        case INCREMENTO:
        case DECREMENTO:
        case ID_FUNCION:
        case IDENTIFICADOR:{
          ;
          break;
          }
        default:
          jj_la1[25] = jj_gen;
          break label_13;
        }
        instruccion();
      }
      jj_consume_token(KCL);
      break;
      }
    case DO:{
      jj_consume_token(DO);
      jj_consume_token(KOP);
      label_14:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case IF:
        case SWITCH:
        case FOR:
        case WHILE:
        case DO:
        case BREAK:
        case CONTINUE:
        case ECHO:
        case INCREMENTO:
        case DECREMENTO:
        case ID_FUNCION:
        case IDENTIFICADOR:{
          ;
          break;
          }
        default:
          jj_la1[26] = jj_gen;
          break label_14;
        }
        instruccion();
      }
      jj_consume_token(KCL);
      jj_consume_token(WHILE);
      jj_consume_token(POP);
      expresion();
listValues.clear();
      jj_consume_token(PCL);
      jj_consume_token(PC);
      break;
      }
    case FOR:{
      jj_consume_token(FOR);
      jj_consume_token(POP);
      expresion();
listValues.clear();
      jj_consume_token(PC);
      expresion();
listValues.clear();
      jj_consume_token(PC);
      expresion();
listValues.clear();
      jj_consume_token(PCL);
      jj_consume_token(KOP);
      label_15:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case IF:
        case SWITCH:
        case FOR:
        case WHILE:
        case DO:
        case BREAK:
        case CONTINUE:
        case ECHO:
        case INCREMENTO:
        case DECREMENTO:
        case ID_FUNCION:
        case IDENTIFICADOR:{
          ;
          break;
          }
        default:
          jj_la1[27] = jj_gen;
          break label_15;
        }
        instruccion();
      }
      jj_consume_token(KCL);
      break;
      }
    default:
      jj_la1[28] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/*
    Esta gramática valida la declaración
    y validación de una variable. En PHP 
    no se pueden declarar las variables sin
    ser inicializadas al mismo tiempo.
*/
  final public void declaracionAsignacion() throws ParseException {Token token;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case IDENTIFICADOR:{
      token = jj_consume_token(IDENTIFICADOR);
System.out.println(token.image);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case IGUAL:
      case MASIGUAL:
      case MENOSIGUAL:
      case MULTIIGUAL:
      case DIVIGUAL:
      case MODIGUAL:
      case PUNTOIGUAL:{
        operadorAsignacion();
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case POP:
        case VALOR_INT:
        case VALOR_DOUBLE:
        case VALOR_BOOLEAN:
        case VALOR_STRING:
        case ID_FUNCION:
        case IDENTIFICADOR:{
          expresion();
try {

                                System.out.println(listValues);
                                int expressionType = SemanticManager.compareTypes(listValues);
                                SemanticManager.addVariable(token , expressionType);

                            } catch(SemanticException ex) {
                                System.err.println(ex);
                            } finally {
                                listValues.clear();
                                System.out.println(listValues);
                            }
          break;
          }
        case ARREGLO:{
          array();
          break;
          }
        default:
          jj_la1[29] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
        }
      case INCREMENTO:{
        jj_consume_token(INCREMENTO);
        break;
        }
      default:
        jj_la1[30] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
      }
    case INCREMENTO:
    case DECREMENTO:{
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case INCREMENTO:{
        jj_consume_token(INCREMENTO);
        break;
        }
      case DECREMENTO:{
        jj_consume_token(DECREMENTO);
        break;
        }
      default:
        jj_la1[31] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      valorIdentificador();
      break;
      }
    default:
      jj_la1[32] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/*
    Valida cualquier operación primitiva 
    que se pueda realizar en PHP, es decir, 
    operaciones aritméticas, relacionales y booleanas.

    La gramática expresión considera a todas 
    estas expresiones como del mismo tipo. Todas
    las expresiones podrán devolver dos tipos 
    de valores a sean booleanos o aritméticos
*/
  final public void expresion() throws ParseException {Token jToken = new Token();
    int type = 0;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case VALOR_BOOLEAN:{
      jToken = jj_consume_token(VALOR_BOOLEAN);
      break;
      }
    case VALOR_INT:{
      jToken = jj_consume_token(VALOR_INT);
      break;
      }
    case VALOR_DOUBLE:{
      jToken = jj_consume_token(VALOR_DOUBLE);
      break;
      }
    case VALOR_STRING:{
      jToken = jj_consume_token(VALOR_STRING);
      break;
      }
    case IDENTIFICADOR:{
      jToken = jj_consume_token(IDENTIFICADOR);
      break;
      }
    case ID_FUNCION:{
      callFuncion();
      break;
      }
    case POP:{
      jj_consume_token(POP);
      expresion();
      jj_consume_token(PCL);
      break;
      }
    default:
      jj_la1[33] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
SemanticManager.instructionTreatment(listValues, jToken, type);
    label_16:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case MAS:
      case MENOS:
      case MULTI:
      case DIV:
      case MOD:
      case IGUAL:
      case MASIGUAL:
      case MENOSIGUAL:
      case MULTIIGUAL:
      case DIVIGUAL:
      case MODIGUAL:
      case PUNTOIGUAL:
      case AND:
      case OR:
      case XOR:
      case IGUALDAD:
      case NOIGUALDAD:
      case IDENTICO:
      case NOIDENTICO:
      case MENOR:
      case MAYOR:
      case MENORIGUAL:
      case MAYORIGUAL:{
        ;
        break;
        }
      default:
        jj_la1[34] = jj_gen;
        break label_16;
      }
      operador();
      expresion();
    }
  }

/*
    Creación de arreglos de formalmente.
    Esta gramática ayuda a especificar 
    claves relacionadas con cada valor 
    del arreglo así como los índices 
    convencionales pero en este caso permiten
    especificar otro tipo de claves asociadas 
    a los valores como strings o enteros.
*/
  final public void array() throws ParseException {
    jj_consume_token(ARREGLO);
    jj_consume_token(POP);
    label_17:
    while (true) {
      valor();
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case COM:{
        jj_consume_token(COM);
        break;
        }
      case IGUAL:{
        jj_consume_token(IGUAL);
        jj_consume_token(MAYOR);
        valor();
        jj_consume_token(COM);
        break;
        }
      default:
        jj_la1[35] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case VALOR_INT:
      case VALOR_DOUBLE:
      case VALOR_BOOLEAN:
      case ID_FUNCION:
      case IDENTIFICADOR:
      case ARRAY:{
        ;
        break;
        }
      default:
        jj_la1[36] = jj_gen;
        break label_17;
      }
    }
    jj_consume_token(PCL);
  }

/*
    Elgoba todos los tipos de operadores
    relacionales, asignación, aritméticos y lógicos
*/
  final public void operador() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case IGUAL:
    case MASIGUAL:
    case MENOSIGUAL:
    case MULTIIGUAL:
    case DIVIGUAL:
    case MODIGUAL:
    case PUNTOIGUAL:{
      operadorAsignacion();
      break;
      }
    case MAS:
    case MENOS:
    case MULTI:
    case DIV:
    case MOD:{
      operadorAritmetico();
      break;
      }
    case IGUALDAD:
    case NOIGUALDAD:
    case IDENTICO:
    case NOIDENTICO:
    case MENOR:
    case MAYOR:
    case MENORIGUAL:
    case MAYORIGUAL:{
      operadorRelacional();
      break;
      }
    case AND:
    case OR:
    case XOR:{
      operadorLogico();
      break;
      }
    default:
      jj_la1[37] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/*
    Engloba todos los tipos de valores
    que se pueden manejar en PHP, desde
    los arreglos, hasta los valores numéricos
*/
  final public void valor() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case IDENTIFICADOR:
    case ARRAY:{
      valorIdentificador();
      break;
      }
    case ID_FUNCION:{
      callFuncion();
      break;
      }
    case VALOR_BOOLEAN:{
      jj_consume_token(VALOR_BOOLEAN);
      break;
      }
    case VALOR_INT:
    case VALOR_DOUBLE:{
      valorNumerico();
      break;
      }
    default:
      jj_la1[38] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/*
    Cualquier valor que sea referenciado
    a través de un identificador. Estos podrían
    ser numéricos, booleanos o cadenas.
*/
  final public void valorIdentificador() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case IDENTIFICADOR:{
      jj_consume_token(IDENTIFICADOR);
      break;
      }
    case ARRAY:{
      jj_consume_token(ARRAY);
      break;
      }
    default:
      jj_la1[39] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/*
    Cualquier tipo de valor numérico
    de tipo entero o decimal (de coma flotante)
*/
  final public void valorNumerico() throws ParseException {Token jToken;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case VALOR_INT:{
      jToken = jj_consume_token(VALOR_INT);
listValues.add(jToken);
      break;
      }
    case VALOR_DOUBLE:{
      jToken = jj_consume_token(VALOR_DOUBLE);
listValues.add(jToken);
      break;
      }
    default:
      jj_la1[40] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/*
    Operadores de asignación
    Para usar estos operadores 
    debe existir un 'valorIdentificador' que lo preceda
    seguido de cualquier expresión.

    Se omiten preincremento, predecremento, posincremento y posdecremento
    por no definir su clase 
*/
  final public void operadorAsignacion() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case IGUAL:{
      jj_consume_token(IGUAL);
      break;
      }
    case MASIGUAL:{
      jj_consume_token(MASIGUAL);
      break;
      }
    case MENOSIGUAL:{
      jj_consume_token(MENOSIGUAL);
      break;
      }
    case MULTIIGUAL:{
      jj_consume_token(MULTIIGUAL);
      break;
      }
    case DIVIGUAL:{
      jj_consume_token(DIVIGUAL);
      break;
      }
    case MODIGUAL:{
      jj_consume_token(MODIGUAL);
      break;
      }
    case PUNTOIGUAL:{
      jj_consume_token(PUNTOIGUAL);
      break;
      }
    default:
      jj_la1[41] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/*
    Operadores Aritméticos
    Estos operadores deben usarse solo en 
    expresiones aritméticas y con operadores numéricos

    Se omiten preincremento, predecremento, posincremento y posdecremento
    por no definir su clase     
*/
  final public void operadorAritmetico() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case MAS:{
      jj_consume_token(MAS);
      break;
      }
    case MENOS:{
      jj_consume_token(MENOS);
      break;
      }
    case MULTI:{
      jj_consume_token(MULTI);
      break;
      }
    case DIV:{
      jj_consume_token(DIV);
      break;
      }
    case MOD:{
      jj_consume_token(MOD);
      break;
      }
    default:
      jj_la1[42] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/*
    Operadores Relacionales
    Estos operadores deben usarse solo en 
    expresiones booleanas y con operandos aritméticos
*/
  final public void operadorRelacional() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case IGUALDAD:{
      jj_consume_token(IGUALDAD);
      break;
      }
    case NOIGUALDAD:{
      jj_consume_token(NOIGUALDAD);
      break;
      }
    case IDENTICO:{
      jj_consume_token(IDENTICO);
      break;
      }
    case NOIDENTICO:{
      jj_consume_token(NOIDENTICO);
      break;
      }
    case MENOR:{
      jj_consume_token(MENOR);
      break;
      }
    case MAYOR:{
      jj_consume_token(MAYOR);
      break;
      }
    case MENORIGUAL:{
      jj_consume_token(MENORIGUAL);
      break;
      }
    case MAYORIGUAL:{
      jj_consume_token(MAYORIGUAL);
      break;
      }
    default:
      jj_la1[43] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/*
    Operadores Lógicos
    Estos operadores deben usarse solo en 
    expresiones booleanas y con operandos lógicos
    que generen valores 'true' o 'flase'

    Se omite la negación por cuestión de número de operandos
    en posteriores utilizaciones
*/
  final public void operadorLogico() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case AND:{
      jj_consume_token(AND);
      break;
      }
    case OR:{
      jj_consume_token(OR);
      break;
      }
    case XOR:{
      jj_consume_token(XOR);
      break;
      }
    default:
      jj_la1[44] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  /** Generated Token Manager. */
  public ComPHPTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[45];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static private int[] jj_la1_2;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
      jj_la1_init_2();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0xa3d240,0xa3d240,0x0,0x0,0x83d240,0x0,0x0,0x830000,0xd240,0x83d240,0x0,0x0,0xa3d240,0xa3d240,0x100,0xa3d240,0xa3d240,0xa3d240,0xa3d240,0x80,0x400,0x83d240,0x83d240,0x800,0x240,0x83d240,0x83d240,0x83d240,0xd000,0x400000,0x0,0x0,0x0,0x0,0xf0000000,0x0,0x0,0xf0000000,0x0,0x0,0x0,0x0,0xf0000000,0x0,0x0,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x300,0x300,0x80000000,0x0,0x300,0x80000000,0x0,0x300,0x0,0x300,0x10000000,0x80000000,0x300,0x300,0x0,0x300,0x300,0x300,0x300,0x0,0x0,0x300,0x300,0x0,0x0,0x300,0x300,0x300,0x0,0x10000000,0x1fe,0x300,0x300,0x10000000,0x3fecff,0x80000002,0x0,0x3fecff,0x0,0x0,0x0,0xfe,0x1,0x3fc000,0x2c00,};
   }
   private static void jj_la1_init_2() {
      jj_la1_2 = new int[] {0x180,0x180,0x0,0x100,0x180,0x0,0x100,0x180,0x0,0x180,0x1f8,0x0,0x180,0x180,0x0,0x180,0x180,0x180,0x180,0x0,0x0,0x180,0x180,0x0,0x0,0x180,0x180,0x180,0x0,0x1f8,0x0,0x0,0x100,0x1f8,0x0,0x0,0x3b8,0x0,0x3b8,0x300,0x18,0x0,0x0,0x0,0x0,};
   }

  /** Constructor with InputStream. */
  public ComPHP(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public ComPHP(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new ComPHPTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 45; i++) jj_la1[i] = -1;
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
    jj_gen = 0;
    for (int i = 0; i < 45; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public ComPHP(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new ComPHPTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 45; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 45; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public ComPHP(ComPHPTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 45; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(ComPHPTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 45; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
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

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[74];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 45; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
          if ((jj_la1_2[i] & (1<<j)) != 0) {
            la1tokens[64+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 74; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}

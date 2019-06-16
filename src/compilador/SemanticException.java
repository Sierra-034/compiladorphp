public class SemanticException extends Exception {

    public SemanticException(SemanticError error, String lexema, int line) {
        super( getMessage( error, lexema, line) );
    }
    
    public static String getMessage( SemanticError error, String lexema, int line) {
        String msg = "";

		switch( error ){
			case DECLARED: msg = "La variable \"" + lexema + "\" ya ha sido declarada.\nLinea: " + line;
				break;
			case NOT_DECLARED: msg = "La variable \"" + lexema + "\" no ha sido declarada.\nLinea: " + line;
				break;
			case DIFFERENT_TYPES: msg = "Los tipos no concuerdan.\nLinea: " + line;
				break;
			case DIFFERENT_DECLARATED: msg = "La variable \"" + lexema + "\" ya ha sido declarada con un tipo de dato diferente.\nLinea: " + line;
				break;
		}
		return msg;
    }
}
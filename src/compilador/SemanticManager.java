package compilador;

import java.util.TreeMap;
import java.util.ArrayList;

public class SemanticManager{
	
	//Tabla de variables
	private static TreeMap<String, Integer> mapaVariables = new TreeMap<String, Integer>();
	private static final int INT = 102;
	private static final int STRING = 100;
	private static final int STRING2 = 101;
	private static final int FLOAT = 103;
	private static final int ID = 104;
	
	public static int compareTypes(ArrayList<Token> listValues) throws SemanticException {
		int type = listValues.get(0).kind;
		for (Token token : listValues) {

			System.out.printf("[token.kind: %d, expected type: %d]\n", token.kind, type);

			if(token.kind != type) {
				System.out.println("holi");
				throw new SemanticException(SemanticError.DIFFERENT_TYPES, 
					token.image, token.beginLine);
			}
		}
		
		return type;
	}
	
	public static void addVariable( Token token, int value ) throws SemanticException { 
		
		System.out.println("Holi");
		
		//Si el Token no está en el mapa de variables, inserto.
		if ( !(boolean)mapaVariables.containsKey( token.image ) ){
			mapaVariables.put( token.image, value );
		}
		else{ //Si ya existe...
			//Obtenemos el token existente en el mapa de variables.
			int t = mapaVariables.get(token.image);
			
			//Comparamos que el nuevo token y el existente sean del mismo tipo. 
			if (value != t) {
				throw new SemanticException( SemanticError.DIFFERENT_DECLARATED, token.image, token.beginLine );
			}
		}
		
	}
	
	//Metodo para verificar si existe una variable
	public boolean checkVariable2( Token token ) throws SemanticException { 
		
		if ( (boolean)!mapaVariables.containsKey( token.image ) )
		throw new SemanticException( SemanticError.NOT_DECLARED, token.image, token.beginLine );
		else
		return true;
	}


	public static int checkVariable(Token variable) throws SemanticException {

		if ( (boolean)!mapaVariables.containsKey( variable.image ) )
			throw new SemanticException( SemanticError.NOT_DECLARED, variable.image, variable.beginLine );
		else
			return mapaVariables.get( variable.image );// int

	}
	
}
package oop.ex7.main.utilities;

/**
 * this class holds the regexses. 
 * @author Admin
 *
 */
public class RagexUtils {
  //  public static final String END_OF_STRING_REG = "\\Z";//The end of the input but for the final terminator, if any
    public static final String LINE_SEPERATOR_REG = "\n";
    public static final String WHITE_SPACE_REG = "\\s";
    public static final String EMPTY_LINE_REG="^\\s*$";
    public static final String COMMENT_LINE_REG="^//.*";
    public static final String IGNORED_LINE_REG=EMPTY_LINE_REG+"|"+COMMENT_LINE_REG;//empty or comment lines are to be ignored
    public static final String PRESERVED_WORDS_REG = "(true|false)";
    public static final String VARIABLE_NAME_REG = "(_*?[a-zA-Z]+\\w*)";//any word inc _
    public static final String METHOD_NAME_REG = "([a-zA-Z]\\w*)";
    //TODO RETURN_TYPE_REG
    public static final String RETURN_TYPE_REG = null;//ie void with () for group 1
    public static final String STRING_REG="\"[^\"]*+\"";        
    public static final String CHAR_REG="'[^']?'";
    public static final String INT_VALUE_REG="-?\\d+";
    public static final String DOUBLE_VALUE_REG="-?\\d+|-?\\d+\\.\\d*|-?\\d*+\\.\\d+";
    public static final String BOOLEAN_EXPRESSION_REG="(true|false|"+VARIABLE_NAME_REG+"|"+DOUBLE_VALUE_REG+")";
    public static final String CONDITION_REG="("+WHITE_SPACE_REG+"*+"+BOOLEAN_EXPRESSION_REG+WHITE_SPACE_REG+"*+"+
            "((&&|\\|\\|)"+WHITE_SPACE_REG+"*+"+BOOLEAN_EXPRESSION_REG+WHITE_SPACE_REG+"*+)*)";
    //TODO Add operators
    public static final String VAR_CONTENT_REG="("+STRING_REG+"|"+CHAR_REG+"|"+DOUBLE_VALUE_REG+"|"+CONDITION_REG+")";//add operators
    public static final String IF_REG="if";
    public static final String WHILE_REG="while";
    //TODO ARRAY_REG
//	private static final String ARRAY_REG = null;
    public static final String INNER_SCOPE_START_REG="("+IF_REG+"|"+WHILE_REG+")"+WHITE_SPACE_REG+
            "*+\\("+CONDITION_REG+"\\)"+WHITE_SPACE_REG+"*+\\{";
    public static final String VARIABLE_TYPE_REG = "\\s*(int|boolean|double|String|char)"; 
    //x=3 part
    public static final String VARIABLE_INITIALIZATION_REG = VARIABLE_NAME_REG+WHITE_SPACE_REG+"*+"+
            "(="+WHITE_SPACE_REG+"*+("+VARIABLE_NAME_REG+"|"+VAR_CONTENT_REG+"\\s*))?";
    public static final String VARIABLE_CHANGE_VALUE_REG ="\\s*"+VARIABLE_NAME_REG+WHITE_SPACE_REG+
            "*(="+WHITE_SPACE_REG+"*+("+VAR_CONTENT_REG+"|"+VARIABLE_NAME_REG+"))\\s*;";
  // int x=3 part
    public static final String VARIABLE_DECLARATION_REG = "("+WHITE_SPACE_REG+"+)?"+
            VARIABLE_TYPE_REG+ WHITE_SPACE_REG+"+("+VARIABLE_INITIALIZATION_REG+"("+WHITE_SPACE_REG
            +"*+,"+WHITE_SPACE_REG+"*+"+VARIABLE_INITIALIZATION_REG+")*);";
    public static final String CLOSEING_BRACKETS_REG="\\}";
    public static final String RETURN_REG="return\\s*;";
    public static final String METHOD_CALL_ARGUMENTS_REG=VARIABLE_NAME_REG+"|"+VAR_CONTENT_REG;
    public static final String METHOD_CALL_REG="\\s*"+METHOD_NAME_REG+"\\s*\\(((\\s*"+METHOD_CALL_ARGUMENTS_REG+
            ")?(\\s*,\\s*(\\s+"+METHOD_CALL_ARGUMENTS_REG+"))*)\\)\\s*[;]";
    public static final String METHOD_DECLARATION_REG=RETURN_TYPE_REG+WHITE_SPACE_REG+"++"+METHOD_NAME_REG+
            WHITE_SPACE_REG+"*\\("+WHITE_SPACE_REG+"*+(|(("+WHITE_SPACE_REG+"+)?("+VARIABLE_TYPE_REG
            +WHITE_SPACE_REG+ "+"+VARIABLE_NAME_REG+"))("+WHITE_SPACE_REG+"*,"+WHITE_SPACE_REG+"*(("
            +WHITE_SPACE_REG+ "+)?("+VARIABLE_TYPE_REG+WHITE_SPACE_REG+"+"+VARIABLE_NAME_REG+")))*)"+WHITE_SPACE_REG
            +"*+\\)"+WHITE_SPACE_REG+"*\\{";
    public static final String OPEN_BRACKETS_REG=METHOD_DECLARATION_REG+"|"+INNER_SCOPE_START_REG;
    public static final String ROOT_LINES_REG=METHOD_DECLARATION_REG+"|"+VARIABLE_DECLARATION_REG+"|"+METHOD_CALL_REG;
    public static final String GOOD_LINE_REG=VARIABLE_CHANGE_VALUE_REG+"|"+ROOT_LINES_REG+"|"+RETURN_REG+
            "|"+CLOSEING_BRACKETS_REG+"|"+INNER_SCOPE_START_REG+"|"+IGNORED_LINE_REG;
    public static final String BOOLEAN_VALUE_REG="true|false|(-?\\d+|-?\\d+\\.\\d*|-?\\d*+\\.\\d+)";

    
//    
//    
    public static final String METHOD_CALL_MATCH_REG = "\\s*[a-zA-Z][a-zA-Z0-9]*+\\s*[(].*[)]\\s*;?";
    public static final String SINGLE_VARIABLE_DECLARATION_REG = "\\s*"+RagexUtils.VALID_MODIFY+RagexUtils.VALID_NAME_REG+"\\s*;";
    public static final String BOOL_EXP = "("+RagexUtils.METHOD_CALL_MATCH_REG+"|(\\w+\\s*[\\>|\\<]\\s*\\w+)|(true|false))";
    public static final String IF_WHILE_REG ="\\s*(if|while)\\s*[\\(]\\s*"+BOOL_EXP+"\\s*[\\)]\\s*\\{";
    public static final String END_SCOPE_REG = "[}]";
    public static final String RETURN_LINE_REG = "\\s*"+"[return]\\s*(.*)?\\s*;";
    public static final String METH_CALL_REG = "(\\s)*?"+".*"+"(\\s)*?"+"[(]"+"(\\s)*?"+".*"+"(\\s)*?"+"([)])"+"(\\s)*?"+"[;]";
    public static final String EXP_REG = "(\\s)?"+"([-])?"+"(\\w)";
    public static final String IS_OPERATOR = "(\\s)?"+EXP_REG+"(\\s)?"+"([+]|[-]|[*]|[/])"+"(\\s)?"+EXP_REG;
    public static final String IN_ARR_CHECK_REG ="(\\s)?"+"(-?\\w+)"+"((\\s)?([\\+\\*\\-\\/]))?((\\s)?(-?\\w+))?";
    public static final String ARR_DECLARE_REG = "(\\s)*?"+"(\\["+"(.*)?"+"\\])?";
    public static final String VALID_NAME_REG = "\\s*\\_*?([a-zA-Z]+\\w*)";
    public static final String VALID_MODIFY = VARIABLE_TYPE_REG+ARR_DECLARE_REG; 
    public static final String VALID_LEFT_SIDE = "\\s*("+VALID_MODIFY+")?\\s*"+VALID_NAME_REG+"\\s*";
    public static final String IS_ARR_DECLARE_REG = VARIABLE_TYPE_REG+"\\s*\\[.*\\]";
    
    public static final String CHAR_MATCH_REG = "\\s*\\'\\s*.\\s*\\'\\s*;?";
    public static final String ARRAY_CONTENT_MATCH = "\\s*\\{.*\\}\\s*;";
    public static final String OPERATOR_CONTENT_MATCH = "\\s*(\\S+)\\s*[\\+|\\*|\\-|\\/]\\s*(\\S+)\\s*;?";
    public static final String INT_MATCH_REG = "\\s*(\\{1|\\-?\\s*[\\d]+)\\s*;?";
    public static final String DOUBLE_MATCH_REG = "\\s*\\-?\\d+(?:\\.\\d+)?\\s*;?";	
    public static final String STRING_MATCH_REG = "\\s*\".*\"\\s*;?";
    public static final String BOOLEAN_MATCH_REG = "\\s*(true|false)\\s*;?";
    public static final String ISNOT_VALID_OPERATOR = "\\s*.*"+RagexUtils.BOOLEAN_MATCH_REG+"|"+
    RagexUtils.STRING_MATCH_REG+"|"+RagexUtils.CHAR_MATCH_REG+".*";
    public static final String OPERATOR_CASE = "(\\w+)[\\*|\\+\\-|\\/](\\w+)";
    public static final String INNER_SPLIT_REG = ",|\\+|\\*|\\-|\\/";
    public static final String METHOD_DECLARE_MATCH_REG = "\\s*(void|"+RagexUtils.VALID_MODIFY+")\\s+"+"\\w+\\s*[\\(].*[\\)\\s*\\{]";
    
    public static final String MINIMAL_CHECK = "\\s*.*[\\{|\\}|\\;]";
    public static final String GROUP_VARIABLE_DECLERATION = "(\\w+(?:\\s*\\[.*\\])?)\\s*(\\w+)";
    public static final String GROUP_SINGLE_VAR = RagexUtils.VALID_NAME_REG+"\\s*(?:\\[\\d+\\]\\s*)?";
    public static final String GROUP_OPERATOR = "^([-]*[^-,+,*,]+)([\\+\\*\\-/])(.+)\\s*$\\s*;?";
    public static final String VALID_SINGLE_VARIABLE = "(\\w+(?:\\s*\\[.*\\])?)\\s*(\\w+)";
    public static final String IS_ASSIGNMENT_OPERATOR = "(.*=.*)(;)";
    public static final String RIGHT_SIDE_IS_ARRAY = "\\s*\\{.*\\}\\s*;?";
}

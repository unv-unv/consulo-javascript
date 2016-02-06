/* The following code was generated by JFlex 1.4.4 on 06.02.16 15:41 */

package org.mustbe.consulo.javascript.lang.lexer;

import com.intellij.lexer.LexerBase;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.javascript.JSTokenTypes;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.4
 * on 06.02.16 15:41 from the specification file
 * <tt>R:/_github.com/consulo/consulo-javascript/src/org/mustbe/consulo/javascript/lang/lexer/javascript15.flex</tt>
 */
public class JavaScript15Lexer extends LexerBase {
  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int DIV_OR_GT = 2;
  public static final int YYINITIAL = 0;
  public static final int LAST_STATE = 4;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2, 2
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\5\1\3\1\16\1\0\1\3\1\10\16\5\4\0\1\3\1\53"+
    "\1\21\1\0\1\4\1\62\1\57\1\17\1\63\1\64\1\7\1\54"+
    "\1\70\1\15\1\13\1\6\1\11\7\1\2\1\1\73\1\67\1\55"+
    "\1\52\1\56\1\72\1\0\4\2\1\14\1\2\21\4\1\12\2\4"+
    "\1\22\1\20\1\23\1\61\1\4\1\0\1\33\1\41\1\43\1\37"+
    "\1\31\1\32\1\24\1\44\1\40\1\4\1\42\1\34\1\24\1\36"+
    "\1\45\1\50\1\4\1\27\1\35\1\26\1\30\1\51\1\47\1\25"+
    "\1\46\1\4\1\65\1\60\1\66\1\71\41\5\2\0\4\4\4\0"+
    "\1\4\2\0\1\5\7\0\1\4\4\0\1\4\5\0\27\4\1\0"+
    "\37\4\1\0\u013f\4\31\0\162\4\4\0\14\4\16\0\5\4\11\0"+
    "\1\4\21\0\130\5\5\0\23\5\12\0\1\4\13\0\1\4\1\0"+
    "\3\4\1\0\1\4\1\0\24\4\1\0\54\4\1\0\46\4\1\0"+
    "\5\4\4\0\202\4\1\0\4\5\3\0\105\4\1\0\46\4\2\0"+
    "\2\4\6\0\20\4\41\0\46\4\2\0\1\4\7\0\47\4\11\0"+
    "\21\5\1\0\27\5\1\0\3\5\1\0\1\5\1\0\2\5\1\0"+
    "\1\5\13\0\33\4\5\0\3\4\15\0\4\5\14\0\6\5\13\0"+
    "\32\4\5\0\13\4\16\5\7\0\12\5\4\0\2\4\1\5\143\4"+
    "\1\0\1\4\10\5\1\0\6\5\2\4\2\5\1\0\4\5\2\4"+
    "\12\5\3\4\2\0\1\4\17\0\1\5\1\4\1\5\36\4\33\5"+
    "\2\0\3\4\60\0\46\4\13\5\1\4\u014f\0\3\5\66\4\2\0"+
    "\1\5\1\4\20\5\2\0\1\4\4\5\3\0\12\4\2\5\2\0"+
    "\12\5\21\0\3\5\1\0\10\4\2\0\2\4\2\0\26\4\1\0"+
    "\7\4\1\0\1\4\3\0\4\4\2\0\1\5\1\4\7\5\2\0"+
    "\2\5\2\0\3\5\11\0\1\5\4\0\2\4\1\0\3\4\2\5"+
    "\2\0\12\5\4\4\15\0\3\5\1\0\6\4\4\0\2\4\2\0"+
    "\26\4\1\0\7\4\1\0\2\4\1\0\2\4\1\0\2\4\2\0"+
    "\1\5\1\0\5\5\4\0\2\5\2\0\3\5\13\0\4\4\1\0"+
    "\1\4\7\0\14\5\3\4\14\0\3\5\1\0\11\4\1\0\3\4"+
    "\1\0\26\4\1\0\7\4\1\0\2\4\1\0\5\4\2\0\1\5"+
    "\1\4\10\5\1\0\3\5\1\0\3\5\2\0\1\4\17\0\2\4"+
    "\2\5\2\0\12\5\1\0\1\4\17\0\3\5\1\0\10\4\2\0"+
    "\2\4\2\0\26\4\1\0\7\4\1\0\2\4\1\0\5\4\2\0"+
    "\1\5\1\4\6\5\3\0\2\5\2\0\3\5\10\0\2\5\4\0"+
    "\2\4\1\0\3\4\4\0\12\5\1\0\1\4\20\0\1\5\1\4"+
    "\1\0\6\4\3\0\3\4\1\0\4\4\3\0\2\4\1\0\1\4"+
    "\1\0\2\4\3\0\2\4\3\0\3\4\3\0\10\4\1\0\3\4"+
    "\4\0\5\5\3\0\3\5\1\0\4\5\11\0\1\5\17\0\11\5"+
    "\11\0\1\4\7\0\3\5\1\0\10\4\1\0\3\4\1\0\27\4"+
    "\1\0\12\4\1\0\5\4\4\0\7\5\1\0\3\5\1\0\4\5"+
    "\7\0\2\5\11\0\2\4\4\0\12\5\22\0\2\5\1\0\10\4"+
    "\1\0\3\4\1\0\27\4\1\0\12\4\1\0\5\4\2\0\1\5"+
    "\1\4\7\5\1\0\3\5\1\0\4\5\7\0\2\5\7\0\1\4"+
    "\1\0\2\4\4\0\12\5\22\0\2\5\1\0\10\4\1\0\3\4"+
    "\1\0\27\4\1\0\20\4\4\0\6\5\2\0\3\5\1\0\4\5"+
    "\11\0\1\5\10\0\2\4\4\0\12\5\22\0\2\5\1\0\22\4"+
    "\3\0\30\4\1\0\11\4\1\0\1\4\2\0\7\4\3\0\1\5"+
    "\4\0\6\5\1\0\1\5\1\0\10\5\22\0\2\5\15\0\60\4"+
    "\1\5\2\4\7\5\4\0\10\4\10\5\1\0\12\5\47\0\2\4"+
    "\1\0\1\4\2\0\2\4\1\0\1\4\2\0\1\4\6\0\4\4"+
    "\1\0\7\4\1\0\3\4\1\0\1\4\1\0\1\4\2\0\2\4"+
    "\1\0\4\4\1\5\2\4\6\5\1\0\2\5\1\4\2\0\5\4"+
    "\1\0\1\4\1\0\6\5\2\0\12\5\2\0\2\4\42\0\1\4"+
    "\27\0\2\5\6\0\12\5\13\0\1\5\1\0\1\5\1\0\1\5"+
    "\4\0\2\5\10\4\1\0\42\4\6\0\24\5\1\0\2\5\4\4"+
    "\4\0\10\5\1\0\44\5\11\0\1\5\71\0\42\4\1\0\5\4"+
    "\1\0\2\4\1\0\7\5\3\0\4\5\6\0\12\5\6\0\6\4"+
    "\4\5\106\0\46\4\12\0\51\4\7\0\132\4\5\0\104\4\5\0"+
    "\122\4\6\0\7\4\1\0\77\4\1\0\1\4\1\0\4\4\2\0"+
    "\7\4\1\0\1\4\1\0\4\4\2\0\47\4\1\0\1\4\1\0"+
    "\4\4\2\0\37\4\1\0\1\4\1\0\4\4\2\0\7\4\1\0"+
    "\1\4\1\0\4\4\2\0\7\4\1\0\7\4\1\0\27\4\1\0"+
    "\37\4\1\0\1\4\1\0\4\4\2\0\7\4\1\0\47\4\1\0"+
    "\23\4\16\0\11\5\56\0\125\4\14\0\u026c\4\2\0\10\4\12\0"+
    "\32\4\5\0\113\4\3\0\3\4\17\0\15\4\1\0\4\4\3\5"+
    "\13\0\22\4\3\5\13\0\22\4\2\5\14\0\15\4\1\0\3\4"+
    "\1\0\2\5\14\0\64\4\40\5\3\0\1\4\3\0\2\4\1\5"+
    "\2\0\12\5\41\0\3\5\2\0\12\5\6\0\130\4\10\0\51\4"+
    "\1\5\126\0\35\4\3\0\14\5\4\0\14\5\12\0\12\5\36\4"+
    "\2\0\5\4\u038b\0\154\4\224\0\234\4\4\0\132\4\6\0\26\4"+
    "\2\0\6\4\2\0\46\4\2\0\6\4\2\0\10\4\1\0\1\4"+
    "\1\0\1\4\1\0\1\4\1\0\37\4\2\0\65\4\1\0\7\4"+
    "\1\0\1\4\3\0\3\4\1\0\7\4\3\0\4\4\2\0\6\4"+
    "\4\0\15\4\5\0\3\4\1\0\7\4\17\0\4\5\32\0\5\5"+
    "\20\0\2\4\23\0\1\4\13\0\4\5\6\0\6\5\1\0\1\4"+
    "\15\0\1\4\40\0\22\4\36\0\15\5\4\0\1\5\3\0\6\5"+
    "\27\0\1\4\4\0\1\4\2\0\12\4\1\0\1\4\3\0\5\4"+
    "\6\0\1\4\1\0\1\4\1\0\1\4\1\0\4\4\1\0\3\4"+
    "\1\0\7\4\3\0\3\4\5\0\5\4\26\0\44\4\u0e81\0\3\4"+
    "\31\0\11\4\6\5\1\0\5\4\2\0\5\4\4\0\126\4\2\0"+
    "\2\5\2\0\3\4\1\0\137\4\5\0\50\4\4\0\136\4\21\0"+
    "\30\4\70\0\20\4\u0200\0\u19b6\4\112\0\u51a6\4\132\0\u048d\4\u0773\0"+
    "\u2ba4\4\u215c\0\u012e\4\2\0\73\4\225\0\7\4\14\0\5\4\5\0"+
    "\1\4\1\5\12\4\1\0\15\4\1\0\5\4\1\0\1\4\1\0"+
    "\2\4\1\0\2\4\1\0\154\4\41\0\u016b\4\22\0\100\4\2\0"+
    "\66\4\50\0\15\4\3\0\20\5\20\0\4\5\17\0\2\4\30\0"+
    "\3\4\31\0\1\4\6\0\5\4\1\0\207\4\2\0\1\5\4\0"+
    "\1\4\13\0\12\5\7\0\32\4\4\0\1\4\1\0\32\4\12\0"+
    "\132\4\3\0\6\4\2\0\6\4\2\0\6\4\2\0\3\4\3\0"+
    "\2\4\3\0\2\4\22\0\3\5\4\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\3\0\1\1\1\2\1\3\1\4\1\1\1\5\1\2"+
    "\1\6\1\7\1\10\1\11\1\12\1\13\15\3\1\14"+
    "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24"+
    "\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34"+
    "\1\35\1\5\1\36\2\2\1\37\1\40\1\41\1\0"+
    "\1\37\1\2\1\42\1\43\2\10\2\11\16\3\1\44"+
    "\1\45\1\46\7\3\1\47\1\50\1\51\1\52\1\53"+
    "\1\54\1\55\1\56\1\57\1\60\1\61\1\62\1\63"+
    "\1\64\1\65\1\66\1\2\1\37\1\41\1\67\1\37"+
    "\2\0\2\10\2\11\1\3\1\70\11\3\1\71\2\3"+
    "\1\72\11\3\1\73\1\3\1\74\1\75\1\76\1\77"+
    "\1\100\1\0\2\67\1\101\1\3\1\102\3\3\1\103"+
    "\4\3\1\104\5\3\1\105\2\3\1\106\1\3\1\107"+
    "\1\110\1\41\1\0\1\111\4\3\1\112\5\3\1\113"+
    "\1\114\1\3\1\115\1\116\1\117\1\120\3\3\1\121"+
    "\1\3\1\122\4\3\1\123\1\124\3\3\1\125\1\3"+
    "\1\126\1\127\1\3\1\130";

  private static int [] zzUnpackAction() {
    int [] result = new int[213];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\74\0\170\0\170\0\264\0\360\0\u012c\0\u0168"+
    "\0\170\0\u01a4\0\u01e0\0\u021c\0\u0258\0\u0294\0\170\0\170"+
    "\0\u02d0\0\u030c\0\u0348\0\u0384\0\u03c0\0\u03fc\0\u0438\0\u0474"+
    "\0\u04b0\0\u04ec\0\u0528\0\u0564\0\u05a0\0\u05dc\0\u0618\0\u0654"+
    "\0\u0690\0\u06cc\0\u0708\0\u0744\0\u0780\0\170\0\170\0\170"+
    "\0\170\0\170\0\170\0\170\0\170\0\170\0\u07bc\0\u07f8"+
    "\0\u0834\0\u0870\0\u08ac\0\u08e8\0\u0924\0\u0960\0\u099c\0\u09d8"+
    "\0\u0a14\0\170\0\170\0\170\0\u0a50\0\u0a8c\0\170\0\u0ac8"+
    "\0\u0b04\0\u0b40\0\u0b7c\0\u0bb8\0\u0bf4\0\u0c30\0\u0c6c\0\u0ca8"+
    "\0\u0ce4\0\u0d20\0\u0d5c\0\u0d98\0\u0dd4\0\360\0\360\0\u0e10"+
    "\0\u0e4c\0\u0e88\0\u0ec4\0\u0f00\0\u0f3c\0\u0f78\0\u0fb4\0\u0ff0"+
    "\0\u102c\0\170\0\170\0\170\0\u1068\0\170\0\170\0\170"+
    "\0\170\0\170\0\170\0\170\0\170\0\170\0\u10a4\0\u10e0"+
    "\0\u111c\0\u1158\0\u1194\0\u11d0\0\u120c\0\u1248\0\u1284\0\u12c0"+
    "\0\u12fc\0\u1338\0\u1374\0\360\0\u13b0\0\u13ec\0\u1428\0\u1464"+
    "\0\u14a0\0\u14dc\0\u1518\0\u1554\0\u1590\0\360\0\u15cc\0\u1608"+
    "\0\360\0\u1644\0\u1680\0\u16bc\0\u16f8\0\u1734\0\u1770\0\u17ac"+
    "\0\u17e8\0\u1824\0\360\0\u1860\0\170\0\170\0\170\0\u189c"+
    "\0\170\0\u18d8\0\u1914\0\170\0\360\0\u1950\0\360\0\u198c"+
    "\0\u19c8\0\u1a04\0\360\0\u1a40\0\u1a7c\0\u1ab8\0\u1af4\0\360"+
    "\0\u1b30\0\u1b6c\0\u1ba8\0\u1be4\0\u1c20\0\360\0\u1c5c\0\u1c98"+
    "\0\360\0\u1cd4\0\360\0\170\0\170\0\u1d10\0\360\0\u1d4c"+
    "\0\u1d88\0\u1dc4\0\u1e00\0\360\0\u1e3c\0\u1e78\0\u1eb4\0\u1ef0"+
    "\0\u1f2c\0\360\0\360\0\u1f68\0\360\0\360\0\360\0\360"+
    "\0\u1fa4\0\u1fe0\0\u201c\0\360\0\u2058\0\360\0\u2094\0\u20d0"+
    "\0\u210c\0\u2148\0\360\0\360\0\u2184\0\u21c0\0\u21fc\0\360"+
    "\0\u2238\0\360\0\360\0\u2274\0\360";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[213];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\4\1\5\1\6\1\7\1\6\1\4\1\10\1\11"+
    "\1\7\1\12\1\6\1\13\1\6\1\14\1\7\1\15"+
    "\1\4\1\16\1\17\1\20\2\6\1\21\1\22\1\23"+
    "\1\24\1\25\2\6\1\26\1\27\1\30\1\31\1\32"+
    "\1\6\1\33\3\6\1\34\1\6\1\35\1\36\1\37"+
    "\1\40\1\4\1\41\1\42\1\43\1\44\1\45\1\46"+
    "\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56"+
    "\1\4\1\5\1\6\1\7\1\6\1\4\1\57\1\60"+
    "\1\7\1\12\1\6\1\13\1\6\1\14\1\7\1\15"+
    "\1\4\1\16\1\17\1\20\2\6\1\21\1\22\1\23"+
    "\1\24\1\25\2\6\1\26\1\27\1\30\1\31\1\32"+
    "\1\6\1\33\3\6\1\34\1\6\1\35\1\36\1\37"+
    "\1\40\1\61\1\41\1\42\1\43\1\44\1\45\1\46"+
    "\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56"+
    "\75\0\1\5\7\0\1\5\1\0\1\62\1\63\14\0"+
    "\1\63\43\0\2\6\1\0\2\6\3\0\2\6\1\0"+
    "\1\6\7\0\26\6\25\0\1\7\4\0\1\7\5\0"+
    "\1\7\55\0\6\64\1\65\1\66\1\0\5\64\1\0"+
    "\1\64\1\67\1\64\1\70\51\64\1\0\1\5\7\0"+
    "\1\5\1\71\1\62\1\63\10\0\1\71\3\0\1\63"+
    "\43\0\1\62\7\0\1\62\77\0\1\72\34\0\1\73"+
    "\21\0\10\15\1\0\5\15\1\0\1\74\1\75\53\15"+
    "\10\16\1\0\5\16\1\0\1\16\1\76\1\77\52\16"+
    "\1\0\2\6\1\0\2\6\3\0\2\6\1\0\1\6"+
    "\7\0\3\6\1\100\14\6\1\101\1\6\1\102\3\6"+
    "\23\0\2\6\1\0\2\6\3\0\2\6\1\0\1\6"+
    "\7\0\5\6\1\103\20\6\23\0\2\6\1\0\2\6"+
    "\3\0\2\6\1\0\1\6\7\0\12\6\1\104\13\6"+
    "\23\0\2\6\1\0\2\6\3\0\2\6\1\0\1\6"+
    "\7\0\10\6\1\105\15\6\23\0\2\6\1\0\2\6"+
    "\3\0\2\6\1\0\1\6\7\0\4\6\1\106\2\6"+
    "\1\107\4\6\1\110\4\6\1\111\4\6\23\0\2\6"+
    "\1\0\2\6\3\0\2\6\1\0\1\6\7\0\23\6"+
    "\1\112\2\6\23\0\2\6\1\0\2\6\3\0\2\6"+
    "\1\0\1\6\7\0\4\6\1\113\1\114\20\6\23\0"+
    "\2\6\1\0\2\6\3\0\2\6\1\0\1\6\7\0"+
    "\5\6\1\115\13\6\1\116\4\6\23\0\2\6\1\0"+
    "\2\6\3\0\2\6\1\0\1\6\7\0\6\6\1\117"+
    "\3\6\1\120\13\6\23\0\2\6\1\0\2\6\3\0"+
    "\2\6\1\0\1\6\7\0\3\6\1\121\22\6\23\0"+
    "\2\6\1\0\2\6\3\0\2\6\1\0\1\6\7\0"+
    "\7\6\1\122\11\6\1\123\4\6\23\0\2\6\1\0"+
    "\2\6\3\0\2\6\1\0\1\6\7\0\14\6\1\124"+
    "\3\6\1\125\5\6\23\0\2\6\1\0\2\6\3\0"+
    "\2\6\1\0\1\6\7\0\7\6\1\126\11\6\1\127"+
    "\4\6\74\0\1\130\73\0\1\131\73\0\1\132\1\0"+
    "\1\133\71\0\1\134\3\0\1\135\67\0\1\136\4\0"+
    "\1\137\66\0\1\140\5\0\1\141\65\0\1\142\73\0"+
    "\1\143\27\0\1\65\1\66\42\0\1\144\73\0\1\145"+
    "\73\0\1\146\2\0\1\147\17\0\1\62\7\0\1\62"+
    "\2\0\1\63\14\0\1\63\43\0\1\150\7\0\1\150"+
    "\3\0\1\150\36\0\1\150\17\0\6\64\1\151\1\64"+
    "\1\0\5\64\1\0\1\64\1\67\1\64\1\70\51\64"+
    "\10\65\1\0\5\65\1\0\55\65\7\152\1\153\64\152"+
    "\10\64\1\0\5\64\1\0\55\64\6\70\1\154\1\70"+
    "\1\155\5\70\1\155\1\70\1\156\2\70\1\64\50\70"+
    "\1\0\2\71\6\0\1\71\2\0\1\71\14\0\3\71"+
    "\3\0\1\71\1\0\1\71\1\0\1\71\30\0\3\15"+
    "\1\157\4\15\1\160\63\15\3\16\1\161\4\16\1\162"+
    "\63\16\1\0\2\6\1\0\2\6\3\0\2\6\1\0"+
    "\1\6\7\0\4\6\1\163\15\6\1\164\3\6\23\0"+
    "\2\6\1\0\2\6\3\0\2\6\1\0\1\6\7\0"+
    "\3\6\1\165\10\6\1\166\11\6\23\0\2\6\1\0"+
    "\2\6\3\0\2\6\1\0\1\6\7\0\24\6\1\167"+
    "\1\6\23\0\2\6\1\0\2\6\3\0\2\6\1\0"+
    "\1\6\7\0\2\6\1\170\23\6\23\0\2\6\1\0"+
    "\2\6\3\0\2\6\1\0\1\6\7\0\13\6\1\171"+
    "\12\6\23\0\2\6\1\0\2\6\3\0\2\6\1\0"+
    "\1\6\7\0\11\6\1\172\14\6\23\0\2\6\1\0"+
    "\2\6\3\0\2\6\1\0\1\6\7\0\12\6\1\173"+
    "\13\6\23\0\2\6\1\0\2\6\3\0\2\6\1\0"+
    "\1\6\7\0\10\6\1\174\15\6\23\0\2\6\1\0"+
    "\2\6\3\0\2\6\1\0\1\6\7\0\12\6\1\175"+
    "\13\6\23\0\2\6\1\0\2\6\3\0\2\6\1\0"+
    "\1\6\7\0\3\6\1\176\22\6\23\0\2\6\1\0"+
    "\2\6\3\0\2\6\1\0\1\6\7\0\14\6\1\177"+
    "\11\6\23\0\2\6\1\0\2\6\3\0\2\6\1\0"+
    "\1\6\7\0\10\6\1\200\15\6\23\0\2\6\1\0"+
    "\2\6\3\0\2\6\1\0\1\6\7\0\23\6\1\201"+
    "\2\6\23\0\2\6\1\0\2\6\3\0\2\6\1\0"+
    "\1\6\7\0\6\6\1\202\1\6\1\203\15\6\23\0"+
    "\2\6\1\0\2\6\3\0\2\6\1\0\1\6\7\0"+
    "\11\6\1\204\14\6\23\0\2\6\1\0\2\6\3\0"+
    "\2\6\1\0\1\6\7\0\5\6\1\205\20\6\23\0"+
    "\2\6\1\0\2\6\3\0\2\6\1\0\1\6\7\0"+
    "\2\6\1\206\6\6\1\207\14\6\23\0\2\6\1\0"+
    "\2\6\3\0\2\6\1\0\1\6\7\0\12\6\1\210"+
    "\13\6\23\0\2\6\1\0\2\6\3\0\2\6\1\0"+
    "\1\6\7\0\2\6\1\211\23\6\23\0\2\6\1\0"+
    "\2\6\3\0\2\6\1\0\1\6\7\0\14\6\1\212"+
    "\11\6\23\0\2\6\1\0\2\6\3\0\2\6\1\0"+
    "\1\6\7\0\3\6\1\213\22\6\23\0\2\6\1\0"+
    "\2\6\3\0\2\6\1\0\1\6\7\0\14\6\1\214"+
    "\11\6\74\0\1\215\73\0\1\216\73\0\1\217\3\0"+
    "\1\220\67\0\1\221\22\0\1\150\7\0\1\150\106\0"+
    "\2\151\12\0\1\151\33\0\7\152\1\222\64\152\6\223"+
    "\1\224\1\153\64\223\23\155\1\64\2\154\12\155\1\154"+
    "\56\155\1\64\50\155\10\70\1\155\5\70\1\155\4\70"+
    "\1\64\50\70\3\15\1\157\4\15\1\160\6\15\1\74"+
    "\1\75\63\15\1\0\6\15\1\74\1\75\53\15\3\16"+
    "\1\161\4\16\1\162\7\16\1\76\1\77\62\16\1\0"+
    "\7\16\1\76\1\77\52\16\1\0\2\6\1\0\2\6"+
    "\3\0\2\6\1\0\1\6\7\0\5\6\1\225\20\6"+
    "\23\0\2\6\1\0\2\6\3\0\2\6\1\0\1\6"+
    "\7\0\21\6\1\226\4\6\23\0\2\6\1\0\2\6"+
    "\3\0\2\6\1\0\1\6\7\0\11\6\1\227\14\6"+
    "\23\0\2\6\1\0\2\6\3\0\2\6\1\0\1\6"+
    "\7\0\5\6\1\230\20\6\23\0\2\6\1\0\2\6"+
    "\3\0\2\6\1\0\1\6\7\0\4\6\1\231\21\6"+
    "\23\0\2\6\1\0\2\6\3\0\2\6\1\0\1\6"+
    "\7\0\5\6\1\232\20\6\23\0\2\6\1\0\2\6"+
    "\3\0\2\6\1\0\1\6\7\0\5\6\1\233\20\6"+
    "\23\0\2\6\1\0\2\6\3\0\2\6\1\0\1\6"+
    "\7\0\17\6\1\234\6\6\23\0\2\6\1\0\2\6"+
    "\3\0\2\6\1\0\1\6\7\0\11\6\1\235\14\6"+
    "\23\0\2\6\1\0\2\6\3\0\2\6\1\0\1\6"+
    "\7\0\7\6\1\236\16\6\23\0\2\6\1\0\2\6"+
    "\3\0\2\6\1\0\1\6\7\0\2\6\1\237\23\6"+
    "\23\0\2\6\1\0\2\6\3\0\2\6\1\0\1\6"+
    "\7\0\10\6\1\240\15\6\23\0\2\6\1\0\2\6"+
    "\3\0\2\6\1\0\1\6\7\0\7\6\1\241\16\6"+
    "\23\0\2\6\1\0\2\6\3\0\2\6\1\0\1\6"+
    "\7\0\5\6\1\242\20\6\23\0\2\6\1\0\2\6"+
    "\3\0\2\6\1\0\1\6\7\0\2\6\1\243\23\6"+
    "\23\0\2\6\1\0\2\6\3\0\2\6\1\0\1\6"+
    "\7\0\7\6\1\244\16\6\23\0\2\6\1\0\2\6"+
    "\3\0\2\6\1\0\1\6\7\0\17\6\1\245\6\6"+
    "\23\0\2\6\1\0\2\6\3\0\2\6\1\0\1\6"+
    "\7\0\5\6\1\246\20\6\23\0\2\6\1\0\2\6"+
    "\3\0\2\6\1\0\1\6\7\0\2\6\1\247\6\6"+
    "\1\250\14\6\23\0\2\6\1\0\2\6\3\0\2\6"+
    "\1\0\1\6\7\0\20\6\1\251\5\6\23\0\2\6"+
    "\1\0\2\6\3\0\2\6\1\0\1\6\7\0\10\6"+
    "\1\252\15\6\23\0\2\6\1\0\2\6\3\0\2\6"+
    "\1\0\1\6\7\0\13\6\1\253\12\6\74\0\1\254"+
    "\21\0\6\152\1\255\1\222\64\152\7\223\1\256\64\223"+
    "\1\0\2\6\1\0\2\6\3\0\2\6\1\0\1\6"+
    "\7\0\23\6\1\257\2\6\23\0\2\6\1\0\2\6"+
    "\3\0\2\6\1\0\1\6\7\0\21\6\1\260\4\6"+
    "\23\0\2\6\1\0\2\6\3\0\2\6\1\0\1\6"+
    "\7\0\3\6\1\261\22\6\23\0\2\6\1\0\2\6"+
    "\3\0\2\6\1\0\1\6\7\0\6\6\1\262\17\6"+
    "\23\0\2\6\1\0\2\6\3\0\2\6\1\0\1\6"+
    "\7\0\2\6\1\263\23\6\23\0\2\6\1\0\2\6"+
    "\3\0\2\6\1\0\1\6\7\0\5\6\1\264\20\6"+
    "\23\0\2\6\1\0\2\6\3\0\2\6\1\0\1\6"+
    "\7\0\10\6\1\265\15\6\23\0\2\6\1\0\2\6"+
    "\3\0\2\6\1\0\1\6\7\0\17\6\1\266\6\6"+
    "\23\0\2\6\1\0\2\6\3\0\2\6\1\0\1\6"+
    "\7\0\4\6\1\267\21\6\23\0\2\6\1\0\2\6"+
    "\3\0\2\6\1\0\1\6\7\0\2\6\1\270\23\6"+
    "\23\0\2\6\1\0\2\6\3\0\2\6\1\0\1\6"+
    "\7\0\7\6\1\271\16\6\23\0\2\6\1\0\2\6"+
    "\3\0\2\6\1\0\1\6\7\0\16\6\1\272\7\6"+
    "\23\0\2\6\1\0\2\6\3\0\2\6\1\0\1\6"+
    "\7\0\20\6\1\273\5\6\23\0\2\6\1\0\2\6"+
    "\3\0\2\6\1\0\1\6\7\0\14\6\1\274\11\6"+
    "\23\0\2\6\1\0\2\6\3\0\2\6\1\0\1\6"+
    "\7\0\2\6\1\275\23\6\23\0\2\6\1\0\2\6"+
    "\3\0\2\6\1\0\1\6\7\0\5\6\1\276\20\6"+
    "\22\0\6\223\1\224\1\256\64\223\1\0\2\6\1\0"+
    "\2\6\3\0\2\6\1\0\1\6\7\0\6\6\1\277"+
    "\17\6\23\0\2\6\1\0\2\6\3\0\2\6\1\0"+
    "\1\6\7\0\12\6\1\300\13\6\23\0\2\6\1\0"+
    "\2\6\3\0\2\6\1\0\1\6\7\0\14\6\1\301"+
    "\11\6\23\0\2\6\1\0\2\6\3\0\2\6\1\0"+
    "\1\6\7\0\14\6\1\302\11\6\23\0\2\6\1\0"+
    "\2\6\3\0\2\6\1\0\1\6\7\0\10\6\1\303"+
    "\15\6\23\0\2\6\1\0\2\6\3\0\2\6\1\0"+
    "\1\6\7\0\20\6\1\304\5\6\23\0\2\6\1\0"+
    "\2\6\3\0\2\6\1\0\1\6\7\0\10\6\1\305"+
    "\15\6\23\0\2\6\1\0\2\6\3\0\2\6\1\0"+
    "\1\6\7\0\5\6\1\306\20\6\23\0\2\6\1\0"+
    "\2\6\3\0\2\6\1\0\1\6\7\0\12\6\1\307"+
    "\13\6\23\0\2\6\1\0\2\6\3\0\2\6\1\0"+
    "\1\6\7\0\12\6\1\310\13\6\23\0\2\6\1\0"+
    "\2\6\3\0\2\6\1\0\1\6\7\0\12\6\1\311"+
    "\13\6\23\0\2\6\1\0\2\6\3\0\2\6\1\0"+
    "\1\6\7\0\21\6\1\312\4\6\23\0\2\6\1\0"+
    "\2\6\3\0\2\6\1\0\1\6\7\0\22\6\1\313"+
    "\3\6\23\0\2\6\1\0\2\6\3\0\2\6\1\0"+
    "\1\6\7\0\2\6\1\314\23\6\23\0\2\6\1\0"+
    "\2\6\3\0\2\6\1\0\1\6\7\0\17\6\1\315"+
    "\6\6\23\0\2\6\1\0\2\6\3\0\2\6\1\0"+
    "\1\6\7\0\4\6\1\316\21\6\23\0\2\6\1\0"+
    "\2\6\3\0\2\6\1\0\1\6\7\0\5\6\1\317"+
    "\20\6\23\0\2\6\1\0\2\6\3\0\2\6\1\0"+
    "\1\6\7\0\12\6\1\320\13\6\23\0\2\6\1\0"+
    "\2\6\3\0\2\6\1\0\1\6\7\0\5\6\1\321"+
    "\20\6\23\0\2\6\1\0\2\6\3\0\2\6\1\0"+
    "\1\6\7\0\5\6\1\322\20\6\23\0\2\6\1\0"+
    "\2\6\3\0\2\6\1\0\1\6\7\0\13\6\1\323"+
    "\12\6\23\0\2\6\1\0\2\6\3\0\2\6\1\0"+
    "\1\6\7\0\21\6\1\324\4\6\23\0\2\6\1\0"+
    "\2\6\3\0\2\6\1\0\1\6\7\0\6\6\1\325"+
    "\17\6\22\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[8880];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;
  private static final char[] EMPTY_BUFFER = new char[0];
  private static final int YYEOF = -1;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\1\10\1\11\4\1\1\11\5\1\2\11\25\1"+
    "\11\11\10\1\1\0\2\1\3\11\2\1\1\11\32\1"+
    "\3\11\1\1\11\11\6\1\2\0\36\1\3\11\1\1"+
    "\1\11\1\0\1\1\1\11\27\1\2\11\1\0\47\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[213];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  private IElementType myTokenType;
  private int myState;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;



  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 1772) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  @Override
  public IElementType getTokenType() {
    if (myTokenType == null) locateToken();
    return myTokenType;
  }

  @Override
  public final int getTokenStart(){
    if (myTokenType == null) locateToken();
    return zzStartRead;
  }

  @Override
  public final int getTokenEnd(){
    if (myTokenType == null) locateToken();
    return getTokenStart() + yylength();
  }

  @Override
  public void advance() {
    if (myTokenType == null) locateToken();
    myTokenType = null;
  }

  @Override
  public int getState() {
    if (myTokenType == null) locateToken();
    return myState;
  }

  @Override
  public void start(final CharSequence buffer, int startOffset, int endOffset, final int initialState) {
    reset(buffer, startOffset, endOffset, initialState);
    myTokenType = null;
  }

   @Override
   public CharSequence getBufferSequence() {
     return zzBuffer;
   }

   @Override
   public int getBufferEnd() {
     return zzEndRead;
   }

  public void reset(CharSequence buffer, int start, int end,int initialState){
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzPushbackPos = 0;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
    myTokenType = null;
  }

   private void locateToken() {
     if (myTokenType != null) return;
     try {
       myState = yystate();
       myTokenType = advanceImpl();
     }
     catch (java.io.IOException e) { /*Can't happen*/ }
     catch (Error e) {
       // add lexer class name to the error
       final Error error = new Error(getClass().getName() + ": " + e.getMessage());
       error.setStackTrace(e.getStackTrace());
       throw error;
     }
   }

   /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position <tt>pos</tt> from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advanceImpl() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL.charAt(zzCurrentPosL++);
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL.charAt(zzCurrentPosL++);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 85: 
          { yybegin(YYINITIAL); return JSTokenTypes.FUNCTION_KEYWORD;
          }
        case 89: break;
        case 28: 
          { yybegin(YYINITIAL); return JSTokenTypes.COLON;
          }
        case 90: break;
        case 4: 
          { return JSTokenTypes.WHITE_SPACE;
          }
        case 91: break;
        case 31: 
          { return JSTokenTypes.REGEXP_LITERAL;
          }
        case 92: break;
        case 78: 
          { yybegin(YYINITIAL); return JSTokenTypes.WHILE_KEYWORD;
          }
        case 93: break;
        case 20: 
          { yybegin(YYINITIAL); return JSTokenTypes.LPAR;
          }
        case 94: break;
        case 65: 
          { yybegin(DIV_OR_GT); return JSTokenTypes.TRUE_KEYWORD;
          }
        case 95: break;
        case 43: 
          { yybegin(YYINITIAL); return JSTokenTypes.GE;
          }
        case 96: break;
        case 81: 
          { yybegin(YYINITIAL); return JSTokenTypes.SWITCH_KEYWORD;
          }
        case 97: break;
        case 33: 
          { return JSTokenTypes.C_STYLE_COMMENT;
          }
        case 98: break;
        case 48: 
          { yybegin(YYINITIAL); return JSTokenTypes.OROR;
          }
        case 99: break;
        case 55: 
          { return JSTokenTypes.DOC_COMMENT;
          }
        case 100: break;
        case 57: 
          { yybegin(YYINITIAL); return JSTokenTypes.FOR_KEYWORD;
          }
        case 101: break;
        case 62: 
          { yybegin(YYINITIAL); return JSTokenTypes.GTGTEQ;
          }
        case 102: break;
        case 25: 
          { yybegin(YYINITIAL); return JSTokenTypes.COMMA;
          }
        case 103: break;
        case 12: 
          { yybegin(YYINITIAL); return JSTokenTypes.EQ;
          }
        case 104: break;
        case 36: 
          { yybegin(YYINITIAL); return JSTokenTypes.DO_KEYWORD;
          }
        case 105: break;
        case 46: 
          { yybegin(YYINITIAL); return JSTokenTypes.ANDAND;
          }
        case 106: break;
        case 42: 
          { return JSTokenTypes.PLUSPLUS;
          }
        case 107: break;
        case 9: 
          { yybegin(YYINITIAL); return JSTokenTypes.STRING_LITERAL;
          }
        case 108: break;
        case 3: 
          { yybegin(DIV_OR_GT);       return JSTokenTypes.IDENTIFIER;
          }
        case 109: break;
        case 24: 
          { yybegin(YYINITIAL); return JSTokenTypes.SEMICOLON;
          }
        case 110: break;
        case 49: 
          { yybegin(YYINITIAL); return JSTokenTypes.XOREQ;
          }
        case 111: break;
        case 79: 
          { yybegin(YYINITIAL); return JSTokenTypes.TYPEOF_KEYWORD;
          }
        case 112: break;
        case 67: 
          { yybegin(YYINITIAL); return JSTokenTypes.ELSE_KEYWORD;
          }
        case 113: break;
        case 64: 
          { yybegin(YYINITIAL); return JSTokenTypes.LTLTEQ;
          }
        case 114: break;
        case 56: 
          { yybegin(YYINITIAL); return JSTokenTypes.TRY_KEYWORD;
          }
        case 115: break;
        case 5: 
          { yybegin(YYINITIAL); return JSTokenTypes.MULT;
          }
        case 116: break;
        case 52: 
          { yybegin(YYINITIAL); return JSTokenTypes.MULTEQ;
          }
        case 117: break;
        case 16: 
          { yybegin(YYINITIAL); return JSTokenTypes.AND;
          }
        case 118: break;
        case 60: 
          { yybegin(YYINITIAL); return JSTokenTypes.EQEQEQ;
          }
        case 119: break;
        case 66: 
          { yybegin(DIV_OR_GT); return JSTokenTypes.THIS_KEYWORD;
          }
        case 120: break;
        case 35: 
          { yybegin(YYINITIAL); return JSTokenTypes.MINUSEQ;
          }
        case 121: break;
        case 51: 
          { yybegin(YYINITIAL); return JSTokenTypes.DIVEQ;
          }
        case 122: break;
        case 59: 
          { yybegin(YYINITIAL); return JSTokenTypes.VAR_KEYWORD;
          }
        case 123: break;
        case 14: 
          { yybegin(YYINITIAL); return JSTokenTypes.PLUS;
          }
        case 124: break;
        case 32: 
          { return JSTokenTypes.END_OF_LINE_COMMENT;
          }
        case 125: break;
        case 68: 
          { yybegin(DIV_OR_GT); return JSTokenTypes.NULL_KEYWORD;
          }
        case 126: break;
        case 76: 
          { yybegin(YYINITIAL); return JSTokenTypes.CATCH_KEYWORD;
          }
        case 127: break;
        case 39: 
          { yybegin(YYINITIAL); return JSTokenTypes.EQEQ;
          }
        case 128: break;
        case 83: 
          { yybegin(YYINITIAL); return JSTokenTypes.FINALLY_KEYWORD;
          }
        case 129: break;
        case 82: 
          { yybegin(YYINITIAL); return JSTokenTypes.DELETE_KEYWORD;
          }
        case 130: break;
        case 73: 
          { yybegin(YYINITIAL); return JSTokenTypes.THROW_KEYWORD;
          }
        case 131: break;
        case 77: 
          { yybegin(YYINITIAL); return JSTokenTypes.CONST_KEYWORD;
          }
        case 132: break;
        case 45: 
          { yybegin(YYINITIAL); return JSTokenTypes.ANDEQ;
          }
        case 133: break;
        case 54: 
          { yybegin(YYINITIAL); return JSTokenTypes.LTLT;
          }
        case 134: break;
        case 30: 
          { yybegin(YYINITIAL); return JSTokenTypes.LT;
          }
        case 135: break;
        case 71: 
          { yybegin(YYINITIAL); return JSTokenTypes.VOID_KEYWORD;
          }
        case 136: break;
        case 13: 
          { yybegin(YYINITIAL); return JSTokenTypes.EXCL;
          }
        case 137: break;
        case 37: 
          { yybegin(YYINITIAL); return JSTokenTypes.IF_KEYWORD;
          }
        case 138: break;
        case 61: 
          { yybegin(YYINITIAL); return JSTokenTypes.NEQEQ;
          }
        case 139: break;
        case 41: 
          { yybegin(YYINITIAL); return JSTokenTypes.PLUSEQ;
          }
        case 140: break;
        case 47: 
          { yybegin(YYINITIAL); return JSTokenTypes.OREQ;
          }
        case 141: break;
        case 86: 
          { yybegin(YYINITIAL); return JSTokenTypes.CONTINUE_KEYWORD;
          }
        case 142: break;
        case 63: 
          { yybegin(YYINITIAL); return JSTokenTypes.GTGTGT;
          }
        case 143: break;
        case 44: 
          { yybegin(YYINITIAL); return JSTokenTypes.GTGT;
          }
        case 144: break;
        case 26: 
          { yybegin(YYINITIAL); return JSTokenTypes.TILDE;
          }
        case 145: break;
        case 84: 
          { yybegin(YYINITIAL); return JSTokenTypes.DEFAULT_KEYWORD;
          }
        case 146: break;
        case 2: 
          { yybegin(DIV_OR_GT); return JSTokenTypes.NUMERIC_LITERAL;
          }
        case 147: break;
        case 18: 
          { yybegin(YYINITIAL); return JSTokenTypes.XOR;
          }
        case 148: break;
        case 29: 
          { yybegin(YYINITIAL); return JSTokenTypes.DIV;
          }
        case 149: break;
        case 15: 
          { yybegin(YYINITIAL); return JSTokenTypes.GT;
          }
        case 150: break;
        case 38: 
          { yybegin(YYINITIAL); return JSTokenTypes.IN_KEYWORD;
          }
        case 151: break;
        case 80: 
          { yybegin(YYINITIAL); return JSTokenTypes.RETURN_KEYWORD;
          }
        case 152: break;
        case 58: 
          { yybegin(YYINITIAL); return JSTokenTypes.NEW_KEYWORD;
          }
        case 153: break;
        case 74: 
          { yybegin(DIV_OR_GT); return JSTokenTypes.FALSE_KEYWORD;
          }
        case 154: break;
        case 8: 
          { return  JSTokenTypes.SINGLE_QUOTE_STRING_LITERAL;
          }
        case 155: break;
        case 17: 
          { yybegin(YYINITIAL); return JSTokenTypes.OR;
          }
        case 156: break;
        case 50: 
          { yybegin(YYINITIAL); return JSTokenTypes.PERCEQ;
          }
        case 157: break;
        case 7: 
          { yybegin(YYINITIAL); return JSTokenTypes.MINUS;
          }
        case 158: break;
        case 34: 
          { return JSTokenTypes.MINUSMINUS;
          }
        case 159: break;
        case 1: 
          { System.out.println(getTokenText()); return JSTokenTypes.BAD_CHARACTER;
          }
        case 160: break;
        case 27: 
          { yybegin(YYINITIAL); return JSTokenTypes.QUEST;
          }
        case 161: break;
        case 75: 
          { yybegin(YYINITIAL); return JSTokenTypes.BREAK_KEYWORD;
          }
        case 162: break;
        case 6: 
          { yybegin(YYINITIAL); return JSTokenTypes.DOT;
          }
        case 163: break;
        case 69: 
          { yybegin(YYINITIAL); return JSTokenTypes.CASE_KEYWORD;
          }
        case 164: break;
        case 11: 
          { yybegin(DIV_OR_GT);       return JSTokenTypes.RBRACKET;
          }
        case 165: break;
        case 23: 
          { yybegin(YYINITIAL); return JSTokenTypes.RBRACE;
          }
        case 166: break;
        case 88: 
          { yybegin(YYINITIAL); return JSTokenTypes.INSTANCEOF_KEYWORD;
          }
        case 167: break;
        case 40: 
          { yybegin(YYINITIAL); return JSTokenTypes.NE;
          }
        case 168: break;
        case 22: 
          { yybegin(YYINITIAL); return JSTokenTypes.LBRACE;
          }
        case 169: break;
        case 21: 
          { yybegin(DIV_OR_GT);       return JSTokenTypes.RPAR;
          }
        case 170: break;
        case 19: 
          { yybegin(YYINITIAL); return JSTokenTypes.PERC;
          }
        case 171: break;
        case 70: 
          { yybegin(YYINITIAL); return JSTokenTypes.WITH_KEYWORD;
          }
        case 172: break;
        case 53: 
          { yybegin(YYINITIAL); return JSTokenTypes.LE;
          }
        case 173: break;
        case 10: 
          { yybegin(YYINITIAL); return JSTokenTypes.LBRACKET;
          }
        case 174: break;
        case 72: 
          { yybegin(YYINITIAL); return JSTokenTypes.GTGTGTEQ;
          }
        case 175: break;
        case 87: 
          { yybegin(DIV_OR_GT); return JSTokenTypes.UNDEFINED_KEYWORD;
          }
        case 176: break;
        default:
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
            return null;
          }
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}

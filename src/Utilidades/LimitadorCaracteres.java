/* Forest Suites es una app hecha en Java para la gestion de
reservas en un hotel, con opciones de crear, modificar y buscar.

Oscar Andres Hernandez Pineda - 2264488
Camilo Andres Garcia - 2264484
Alejandro Cuenca - 22644755

Ult. fecha modificacion: 20/10/2023
Version 2.0
*/

package utilidades;

public class LimitadorCaracteres extends javax.swing.text.PlainDocument
{
    private javax.swing.text.JTextComponent editor;//El editor al que se limita los caracteres
    
    private int numeroMaximoCaracteres;//numero maximo de caracteres que se desean en el editor   
    
    private int tipo;//Indica que tipo de datos se aceptaran en el editor
    
    /**
     * Crea una instancia de LimitadorCaracteres.
     * 
     * @param editor Editor en el que se quieren limitar los caracteres.
     * @param numeroMaximoCaracteres Numero maximo de caracteres que queremos
     * @param tipo Atributo que indica el tipo de campo
     *              0 = numerico, 1 = alfanumerico, 2 = ambos, 3 = reales
     */
    public LimitadorCaracteres(javax.swing.text.JTextComponent editor, int numeroMaximoCaracteres, int tipo)
    {
        this.editor=editor;
        this.numeroMaximoCaracteres=numeroMaximoCaracteres;  
        this.tipo=tipo;
    }
    
    /**
     * M�todo al que llama el editor cada vez que se intenta insertar caracteres.
     * El metodo comprueba que no se sobrepasa el limite. Si es asi, llama al
     * metodo de la clase padre para que se inserten los caracteres. Si se 
     * sobrepasa el limite, retorna sin hacer nada.
     */
    public void insertString(int arg0, String arg1, javax.swing.text.AttributeSet arg2) throws javax.swing.text.BadLocationException
    {
    	//arg1 = arg1.toUpperCase();
    	
       switch(tipo)
       {
           case 0: for(int i=0; i<arg1.length(); i++)                 
                        if(!Character.isDigit(arg1.charAt(i)))
                            return;
                            break;
                            
           case 1:  for(int i=0; i<arg1.length(); i++)                 
                        if(!Character.isLetter(arg1.charAt(i)) && !Character.isWhitespace(arg1.charAt(i)))
                            return;
                            break;
           
           case 2 : for(int i=0; i<arg1.length(); i++)                 
                        if(!Character.isLetterOrDigit(arg1.charAt(i)) && !Character.isWhitespace(arg1.charAt(i)) && 
                        		arg1.charAt(i) != '-' && arg1.charAt(i) != '#' && arg1.charAt(i) != '.' && arg1.charAt(i) != '(' && 
                        		arg1.charAt(i) != ')')
                            return;
                            break;
           
           case 3: for(int i=0; i<arg1.length(); i++)                 
                        if(!Character.isDigit(arg1.charAt(i)) && arg1.charAt(i) != '.')
                            return;
                            break;                              	                                              
           
           case 4: for(int i=0; i<arg1.length(); i++)                 
                        if(!Character.isDigit(arg1.charAt(i)) && arg1.charAt(i) != ',')
                            return;
                            break;
                            
           default: break;
       }     

        if ((editor.getText().length()+arg1.length())>this.numeroMaximoCaracteres)
        {
           editor.getToolkit().beep();
            return;
        }

        super.insertString(arg0, arg1, arg2);
    }
}
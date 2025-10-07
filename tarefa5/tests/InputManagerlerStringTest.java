package tests;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import app.InputManager;

public class InputManagerlerStringTest{
    private final InputStream originalSystemIn = System.in;
    private final PrintStream originalOut = System.out;
    private ByteArrayInputStream testIn;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    
    @AfterEach
    /*
    * Restaura a entrada e saida padrao.
    * Boa pratica que todo e qualquer teste que mude System.in ou System.out deve fazer,
    * pois evita problemas em outros testes.
    */
    void restoreStreams() {
    System.setIn(originalSystemIn);
    System.setOut(originalOut);
    }
    
    /*
    * Simula a entrada do usuario
    * @param data String representando a entrada a ser testada.
    */
    private void provideInput(String data) {
    testIn = new ByteArrayInputStream(data.getBytes());
    System.setIn(testIn);
    }
    
    @Test
    public void 

}

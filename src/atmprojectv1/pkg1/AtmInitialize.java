
package atmprojectv1.pkg1;

public class AtmInitialize {
    public void start(){
        ATM globalbank=new ATM();
        globalbank.chkCard();
        globalbank.chooseLanguage();
        globalbank.enterPIN();
    }
    
    
}

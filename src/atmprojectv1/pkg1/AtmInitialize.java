
package atmprojectv1.pkg1;

public class AtmInitialize {
    public void start(){
        ATM globalbank=new ATM();
        if(globalbank.chkCard()==1){
            globalbank.chooseLanguage();
        }
        else{
            System.out.println("ReInsert your Card Again");
            start();
        }
    }
    
    
}

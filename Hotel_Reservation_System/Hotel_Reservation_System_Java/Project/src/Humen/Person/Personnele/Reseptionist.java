package Humen.Person.Personnele;

import Humen.Person.KeyManage.Key;

public class Reseptionist extends Personnele implements CanTranslate {

    private char[] reseptionistId;
    // receptionist has the room keys
    private static final int MAX_KEYS = 10;
    private Key[] takenKey = new Key[MAX_KEYS];
    private int keyCount = 0;
    // composition relation of language ability of reseptionists
    private LanguageState languageState;

    public Reseptionist(String firstName, String lastName, String nationalCode, String reseptionistId)
            throws Exception {
        super(firstName, lastName, nationalCode, reseptionistId);
    }

    // setters
    public void setLanguageState(LanguageState languageState) {
        this.languageState = languageState;
    }

    // getters
    public static int getMAX_KEYS() {
        return MAX_KEYS;
    }

    public Key[] getKey() {
        return takenKey;
    }

    public void addKeys(Key k) {
        takenKey[keyCount++] = k;
    }

    public LanguageState getLanguageState() {
        return languageState;
    }

    @Override
    public char[] getPersonneleId() {
        return reseptionistId;
    }

    // see if the reseptionist can help traveler with language issues
    @Override
    public void translate(LanguageState languageState, String names) {
        switch (languageState) {
            case MONO_LINGUAL:
                System.out.println(names + ":  ** The reseptionist Can Not Translate. **");
                break;
            case BI_LINGUAL:
                System.out.println(names + ":  ** The reseptionist Can Only communicate via English. **");
                break;
            case POLY_LINGUAL:
                System.out.println(names + ":  ** The reseptionist Can Translate in any language you speack. **");
                break;
        }
    }
}

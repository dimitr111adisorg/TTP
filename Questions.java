package progrII;

public class Questions {

    public String [][] questions;

    public Questions() {
        questions = new String[10][5];
    }

    protected String [][] French() {
        questions[0][0] = "What does the following sentence mean? \nAs tu été surprise par le bonnes nouvelles?";
        questions[0][1] = "Did you hear the good news?";
        questions[0][2] = "Were you surprised by the good news?";
        questions[0][3] = "Were you surprised by the news?";
        questions[0][4] = "b";
        questions[1][0] = "Je _____ mes devoirs";
        questions[1][1] = "finis";
        questions[1][2] = "finit";
        questions[1][3] = "finise";
        questions[1][4] = "a";
        questions[2][0] = "Identify the word that means the OPPOSITE of the given term.\nParesseux";
        questions[2][1] = "Malheureux";
        questions[2][2] = "Avare";
        questions[2][3] = "Actif";
        questions[2][4] = "c";
        questions[3][0] = "Choose the BEST translation.\nAprès le dîner, je me detends au salon dans un 'chaise longue.'";
        questions[3][1] = "rocking chair";
        questions[3][2] = "automated chair";
        questions[3][3] = "long chair";
        questions[3][4] = "c";
        questions[4][0] = "Elles vont manger _____ poulet.";
        questions[4][1] = "de la";
        questions[4][2] = "du";
        questions[4][3] = "des";
        questions[4][4] = "a";
        questions[5][0] = "_____ chocolat préfères-tu?";
        questions[5][1] = "Quelles";
        questions[5][2] = "Quel";
        questions[5][3] = "Quels";
        questions[5][4] = "b";
        questions[6][0] = "Quel est le contraire de 'petit'?";
        questions[6][1] = "Grand";
        questions[6][2] = "Rapide";
        questions[6][3] = "Bleu";
        questions[6][4] = "a";
        questions[7][0] = "Quel est le synonyme de 'heureux'?";
        questions[7][1] = "Triste";
        questions[7][2] = "Fatigué";
        questions[7][3] = "Joyeux";
        questions[7][4] = "c";
        questions[8][0] = "Quelle est la signification de l'expression 'mettre de l'eau dans son vin' ?";
        questions[8][1] = "Boire du vin";
        questions[8][2] = "Adoucir ses paroles, modérer ses exigences";
        questions[8][3] = "Faites vos affaires";
        questions[8][4] = "b";
        questions[9][0] = "Quel est le synonyme du mot 'ubiquité' ?";
        questions[9][1] = "Omniprésence";
        questions[9][2] = "Éphémère";
        questions[9][3] = "Oblique";
        questions[9][4] = "a";
        return questions;
    } 

    protected String[][] Spanish() {
        questions[0][0] = "¿Cuál es el verbo en la siguiente frase?\n'Ella canta una canción'";
        questions[0][1] = "Ella";
        questions[0][2] = "canta";
        questions[0][3] = "canción";
        questions[0][4] = "b";
        questions[1][0] = "¿Cuál es la forma correcta del verbo 'ser' en la primera persona del singular (yo)?";
        questions[1][1] = "Es";
        questions[1][2] = "Somos";
        questions[1][3] = "Soy";
        questions[1][4] = "c";
        questions[2][0] = "Completa la frase: 'Ella ___________ una bicicleta nueva.'";
        questions[2][1] = "tiene";
        questions[2][2] = "tengo";
        questions[2][3] = "tienes";
        questions[2][4] = "a";
        questions[3][0] = "Elige la palabra correcta para completar la oración:\n'Voy a la tienda ________ comprar comida.'";
        questions[3][1] = "para";
        questions[3][2] = "pero";
        questions[3][3] = "y";
        questions[3][4] = "a";
        questions[4][0] = "Elige la forma correcta del verbo en la frase:\n'Ellos ________ al cine anoche.'";
        questions[4][1] = "ir";
        questions[4][2] = "vamos";
        questions[4][3] = "fueron";
        questions[4][4] = "c";
        questions[5][0] = "¿Cuál es el antónimo de la palabra 'rápido'?";
        questions[5][1] = "fuerte";
        questions[5][2] = "lento";
        questions[5][3] = "alto";
        questions[5][4] = "b";
        questions[6][0] = "¿Cuál es el pronombre posesivo correcto para la palabra 'libro' en la frase 'Es __________ libro'?";
        questions[6][1] = "su";
        questions[6][2] = "nuestro";
        questions[6][3] = "tu";
        questions[6][4] = "b";
        questions[7][0] = "¿Cuál es la traducción correcta de la palabra 'pelota' al inglés?";
        questions[7][1] = "Ball";
        questions[7][2] = "Hat";
        questions[7][3] = "Chair";
        questions[7][4] = "a";
        questions[8][0] = "¿Cuál es el sinónimo de la palabra 'contento'?";
        questions[8][1] = "Triste";
        questions[8][2] = "Cansado";
        questions[8][3] = "Feliz";
        questions[8][4] = "c";
        questions[9][0] = "¿Cuál es el significado de la expresión 'echar agua al mar'?";
        questions[9][1] = "Hacer una tarea difícil";
        questions[9][2] = "Realizar algo imposible o inútil";
        questions[9][3] = "Beber agua de mar";
        questions[9][4] = "b";
        return questions;
    }

    protected String[][] Italian() {
        questions[0][0] = "Qual è il contrario di 'grande'?";
        questions[0][1] = "Nuovo";
        questions[0][2] = "Piccolo";
        questions[0][3] = "Lungo";
        questions[0][4] = "b";
        questions[1][0] = "Quale di queste opzioni è un animale??";
        questions[1][1] = "Tavolo";
        questions[1][2] = "Libro";
        questions[1][3] = "Pesce";
        questions[1][4] = "c";
        questions[2][0] = "Completa la frase con il pronome corretto: \n'____ ho visto ieri al supermercato.'";
        questions[2][1] = "Lo";
        questions[2][2] = "Ti";
        questions[2][3] = "Lei";
        questions[2][4] = "a";
        questions[3][0] = "Scegli l'opzione corretta per il tempo futuro: \n'Domani ___ al cinema.'";
        questions[3][1] = "Vado";
        questions[3][2] = "Andavo";
        questions[3][3] = "Andrò";
        questions[3][4] = "c";
        questions[4][0] = "Qual è la forma corretta dell'aggettivo per la frase: 'Il gatto è ____'?";
        questions[4][1] = "Grande";
        questions[4][2] = "Grandi";
        questions[4][3] = "Grand";
        questions[4][4] = "a";
        questions[5][0] = "Quale di queste opzioni è un colore?";
        questions[5][1] = "Letto";
        questions[5][2] = "Rosso";
        questions[5][3] = "Correre";
        questions[5][4] = "b";
        questions[6][0] = "Quale forma verbale è corretta per la frase \n'Loro ___ molto bene'?";
        questions[6][1] = "Parlano";
        questions[6][2] = "Parla";
        questions[6][3] = "Parliamo";
        questions[6][4] = "a";
        questions[7][0] = "Quale di queste opzioni si riferisce a un oggetto che si usa per scrivere?";
        questions[7][1] = "Tavolo";
        questions[7][2] = "Carta";
        questions[7][3] = "Penna";
        questions[7][4] = "c";
        questions[8][0] = "Completa la frase con il modo corretto del congiuntivo: \n'Se tu ___ che lui avesse ragione, accetteresti la sua proposta.'";
        questions[8][1] = "Pensassi";
        questions[8][2] = "Pensare";
        questions[8][3] = "Pensi";
        questions[8][4] = "a";
        questions[9][0] = "Scegli l'opzione corretta per il periodo ipotetico della realtà: 'Se studiassi di più, ___ migliori voti.'";
        questions[9][1] = "Otterrei";
        questions[9][2] = "Otterresti";
        questions[9][3] = "Ottenete";
        questions[9][4] = "b";
        return questions;
    }

}



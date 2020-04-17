package com.example.apprendrevocabulaire;

// a cahque nouvelle Liste 3 endroits à modifier:
//décalrtion des listes
//changer liste
// lancement recherche: chargement de la liste

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView texteAfficher;
    private TextView texteCompteRebours;
    private TextView texteRomaji;
    private TextView texteHira;
    private TextView texteNomListeEncours;
    private TextView texteNboccurence;
    private Button boutonMotSuivant;
    private Button boutonAfficherReponse;
    private Button boutonChangerListe;

    //Ondeclare une liste de reférence et on copiera la liste dessus
    private String[] listeRef = new String[] {};

    //déclaration bourrine des listes de vocabulaires
    private String Voca1 = "ELV voca lecon 1";
    private String[] Vocabulaire1 = new String[]{
            "ken","ken","けん","shigeru","shigeru","しげる","natari","natari","ナタリ-","etudiant","gakusei","がくせい","Yamada","Yamada","やまだ","prof","sensei ","せんせい","entreprise","kaisha ","かいしゃ","employé","kashain","かしゃいん","president","daitoryou","だいとうりょう","biere","bi-ru","ビ-ル","vin","wain","ワイン","café","kohi","コ-ヒ-","thé","o cha","おちゃ","saké","osake ","おさけ","tabac","tabako ","タバコ","bananes","banana ","バナナ","whisky","uisuki","ウイスキ","jus de fruits","ju-su","ジュ-ス ","tomates","tomato","トマト","japon","nihon","日本","japonais","nihon go","にほん ご","France","Furansu","フランス","japonais","nihon jin","日本人","Allemagne","do i tsu","ドイツ","Italie","itaria","イタリア","Angleterre","i gi ri su","イギリス","anglais","eigo","えいご","US","amerika","アメリカ","chine","chuugoku","ちゅうごく","anglais","eigo","えいご","US","amerika","アメリカ"
    };

    private String Voca10avril ="Voca 10 avril 2019";
    private String[] Vocabulaire10avril = new String[] {
            "taxi","takushi","タクシ","malade","byouki","びょうき","se reposer","yasumimasu","やすみます","feuille","kami","かみ","couper","kirimasu","きります","argent","okone","おこね","bibliotheque","toshokan","としょかん","année derniere","kyonen","きょねん","cette année","kotoshi","ことし","spectacle","geki","げき","foret","mori","もり","famille","karuto","かると","bonne nuit","oyasumi","おやすみ","maintenant","ima","いま","se lever","okimasu","おきます","dormir","nemasu","ねます","zéro","rei","れい","taxi","takushi","タクシ"

    };

    //Verbe version longue
    private String VocaVerbeLivreAutres = "ELJ Verbe livre p62-63 + autres"  ;
    private String[] VocaVerbeELVp62EtAutres = new String[] {
            "lire un livre","hon o yomimasu","ほん を よみます","appeler heler (un taxi)","yobimasu","タクシ-  を よびます","parler le japonias","nihongo de hanashimasu","日本ご で はなします","payer avec de l'argent","okane o haraimasu","お金 を はらいます","rencontrer","aimasu","あいます","laver les mains","te o araimasu","て を あらいます","ouvri une fenetre","mado o akemasu","まど を あけます", "fermer uen fenetre","mado o shimemasu", "まど を しめます","allumer la tele","terebi o tsukemasu","テレビをつけます","eteindre la tele","terebi o keshimasu","テレビをけします","poser un livre","hon o okimasu"," 本 を おきます","prendre  un livre","hon o torimasu","本 をとります","mettre dedans, un verre","koppu o iremasu","コップ を いれます","sortir de , un verre","koppu o dashimasu","コップ をだします","prendre(transport) le train","densha ni norimasu","でんしゃ に のります","descendre(transport) du train","densha o orimasu","でんしゃ を おります","marcher","arukimasu","あるきます","courir","hashirimasu","はしります","jouer au tennis","tenise o shimasu","テニセ を します","jouer au carte","toranpu o shimasu","トランプを します","faire des études","benkyou o shimasu","べんきょう を します","se promener","sanpo o shimasu","さんぽ を します","faire du travail","shigoto o shimasu","しごと を します","faire la ménage","souji o shimasu","そうじ を します","faire la lessive","sentaku o shimasu","せんたく を します","conduire","unten o shimasu","うんてん を します","réparer","shuuri o shimasu","しゅうり を します","se marrier"," kekkou o shimasu","けっこう を します","se reposer","yasumimasu","やすみます","réparer","shuuri o shimasu","しゅうり を します","se marrier","  kekkon o shimasu", "けっこん を します","couper","kirimasu","きります","se lever","okimasu","おきます","travailler","atarakimasu","あたらきます","jouer","Asobimasu","あそびます","compter","kazoemasu","かぞえます","avoir une discussion","hanashi o shimasu","はなし を します","donner","agemasu","あげます","recevoir","moraimasu","もらいます","enseigner","oshiemasu","おしえます","apprendre","naraimasu","ならいます","appeler tel","kakemasu","かけます","envoyer/offrir","okurimasu","おくります","preter","kashimasu","かします","emprunter","karimasu","かります","boire et manger","itadakimasu","いただきます",
    };

    //Verbe très court
    private String VocaVerbeAutres = "ELJ Verbe autres" ;
    private String[] VocaVerbeAutresListe = new String[] {
            "se reposer","yasumimasu","やすみます","couper","kirimasu","きります","se lever","okimasu","おきます","travailler","atarakimasu","あたらきます","jouer","Asobimasu","あそびます","compter","kazoemasu","かぞえます","avoir une discussion","hanashi o shimasu","はなし を します","donner","agemasu","あげます","recevoir","moraimasu","もらいます","enseigner","oshiemasu","おしえます","apprendre","naraimasu","ならいます","appeler tel","kakemasu","かけます","envoyer/offrir","okurimasu","おくります","preter","kashimasu","かします","emprunter","karimasu","かります","boire et manger","itadakimasu","いただきます",

    };

    //verbe livre p62-63
    private String VocaVerbe = "ELJ Verbe livre p62-63"  ;
    private String[] VocaVerbeELVp57 = new String[] {
            "lire un livre","hon o yomimasu","ほん を よみます","appeler heler (un taxi)","yobimasu","タクシ-  を よびます","parler le japonias","nihongo de hanashimasu","日本ご で はなします","payer avec de l'argent","okane o haraimasu","お金 を はらいます","rencontrer","aimasu","あいます","laver les mains","te o araimasu","て を あらいます","ouvri une fenetre","mado o akemasu","まど を あけます","fermer uen fenetre","mado o shimemasu", "まど を しめます","allumer la tele","terebi o tsukemasu","テレビをつけます","eteindre la tele","terebi o keshimasu","テレビをけします","poser un livre","hon o okimasu"," 本 を おきます","prendre  un livre","hon o torimasu","本 をとります","mettre dedans, un verre","koppu o iremasu","コップ を いれます","sortir de , un verre","koppu o dashimasu","コップ をだします","prendre(transport) le train","densha ni norimasu","でんしゃ に のります","descendre(transport) du train","densha o orimasu","でんしゃ を おります","marcher","arukimasu","あるきます","courir","hashirimasu","はしります","jouer au tennis","tenise o shimasu","テニセ を します","jouer au carte","toranpu o shimasu","トランプを します","faire des études","benkyou o shimasu","べんきょう を します","se promener","sanpo o shimasu","さんぽ を します","faire du travail","shigoto o shimasu","しごと を します","faire la ménage","souji o shimasu","そうじ を します","faire la lessive","sentaku o shimasu","せんたく を します","conduire","unten o shimasu","うんてん を します","réparer","shuuri o shimasu","しゅうり を します","se marrier"," kekkou o shimasu","けっこう を します","réparer","shuuri o shimasu","しゅうり を します","se marrier","  kekkon o shimasu", "けっこん を します",

    };

    private String VocaELV2 ="Voca ELV lecon 2";
    private String[] VocaELVlecon2 = new String[] {


            "Hergé","eruju","エルジュ","mishima (auteur)","mishima","みしま","musique","ongaku","おんがく","jazz","jazu","ジャズ","CD","shidi","CD","classique","kurashikku","クラシック","rock","rokku","ロック","livre","hon","本","manga","manga","まんが","magazine","zasshi","ざっし","journal","shinbun","しんぶん","télévision","terebi","テレビ","radio","rajio","ラジオ","appareil photo","kamera","カメラ","stylo bille","borupen","ボールペン","crayon papier","enpitsu","えんぴつ","cendrier","haizara","はいざら","montre","tokei","とけい","parapluie","kasa","かさ","chien","inu","いぬ","film ","eiga","えいが"
    };

    private String VocaELV3 ="Voca ELV lecon 3";
    private String[] VocaELVlecon3 = new String[] {


            "cuisine","daidokoro","だいどころ","fenetre","mado","まど","petit dej","asagohan","あさごはん","diner (repas)","bangohan","ばんごはん","déjeuner (repas)","hirugohan","ひるごはん","œufs","tamago","たまご","frigo","reizouko","れいぞうこ","sel","shio","しお","poivre","koshou","こしょう","étagere","tana","たな","dedans","naka","なか","sur","ue","うえ","sous","shita","した","a coté","yoko","よこ","devant","mae","まえ","derrière","ushiro","うしろ","bibliotheque","hondana","本だな","chat","neko","ねこ","velo","jitensha","じてんしゃ","voiture","kuruma","くるま","porte","doa","ドア","table","te-buru","テ-ブル","salle","heya","へや","briquet","raita-","ライタ-","verre","koppu","コップ","lit","beddo","ベッド","balle","boru","ボール","fleur","hana","はな","vase","kabin","かびん","balle","boru","ボール","fleur","hana","はな","telphone","denwa","でんわ","bureau","tsukue","つくえ","chaise","isu","いす","gare","eki","えき","parc","kouen","こうえん","arret taxi","takushi- noriba","タクシ- のりば","arret bus","basu-noriba","バス- のりば","bureau de poste","yuubinkyoku","ゆうびんきょく","hopital","byo u in","びょ う いん","ecole","gakkou","がっこう","parking","chuushajou","ちゅうしゃじょう","riviere","kawa","かわ","pont","hashi","はし","hotel","hoteru","ホテル","restaurant","resutoran","レストラン","cinema","eigakan","えいがかん","supermarché","su-pa-","ス-パ-","fleuriste","hanaya","はなや","banque","ginkou","ぎんこう","librairie","honya","本ゃ","poissonnerie","sakanaya","さかなや","Fruits et leg magazin","ya o ya","や お や","boucherie","nikuya","にくや","maison","uchi  /ou/   ie","うち  ou いえ ","café (salon de thé)","kissaten","きっさてん"

    };


    //vocabulaire du 8 mai
    private String Voca8mai ="Voca 8 mai 2019";
    private String[] Voca8maiPerso  = new String[] {


            "rouler (vb)","makimasu","まきます","malade","byouki","びょうき","feuille","kami","かみ","maintenant","ima","いま","spectacle","geki","げき","tout","zenbu","ぜんぶ","travailler","atarakimasu","あたらきます","jouer","Asobimasu","あそびます","compter","kazoemasu","かぞえます","cadeau","omiyake","おみやけ","hopital","byouin","びょういん","compter (manière de)","kazoekata","かぞえかた","habiller (vb)","kimasu","きます","soupe (raffiné)","suimono","すいもの","vacances","oyasumi","おやすみ","vacances en or","goruden wiku","ゴールデン ウィーク","chanter","utaimasu","うたいます","chant","uta","うた","danser","odorimasu","おどります","emprunt ( chose emprunter)","karimono","かりもの","dormir","nemasu","ねます","rouleau (papier..)","makimono","まきもの"
    };

    //que des mots en hiragan
    private String VocaHira = "que des mots en hiragana"  ;
    private String[] vocaHiragana = new String[] {
            "taxi","takushi","タクシ","sandwich","sando wi chi","サンド ウィッ チ","jeu","game","ガメ","omelette","Omuretsu","オムレツ","supermarché","su-pa-","ス-パ-","restaurant","resutoran","レストラン","radio","rajio","ラジオ","recette","reshipe","レシペ","pizza","pi za","ピ ザ ","glace","aisukurimu","アイスクリム","telé","terebi","テレビ","arret taxi","takushi- noriba","タクシ- のりば","arret bus","basu-noriba","バス- のりば","balle","boru","ボール","porte","doa","ドア","table","te-buru","テ-ブル","briquet","raita-","ライタ-","verre","koppu","コップ","lit","beddo","ベッド","jazz","jazu","ジャズ","rock","rokku","ロック","Hergé","eruju","エルジュ","classique","kurashikku","クラシック","stylo bille","borupen","ボールペン","vacances en or","goruden wiku","ゴールデン ウィーク"
               };



    private List<Integer> listAlaetoire = new ArrayList<Integer>();
    private int RefAAfficher;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.texteAfficher = findViewById(R.id.texteAfficher);
        this.texteCompteRebours = findViewById(R.id.texteCompteRebours);
        this.texteHira = findViewById(R.id.texteHira);
        this.texteRomaji = findViewById(R.id.texteRomaji);
        this.texteNboccurence = findViewById(R.id.texteNboccurence);
        this.texteNomListeEncours = findViewById(R.id.texteNomListeEncours);
        this.boutonMotSuivant = findViewById(R.id.boutonMotSuivant);
        this.boutonAfficherReponse = findViewById(R.id.boutonAfficherReponse);
        this.boutonChangerListe = findViewById(R.id.boutonChangerListe);

        //on vide les textView
        texteRomaji.setText("");
        texteHira.setText("");



        //action bouton si clique que Mot Suivant
        boutonMotSuivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RefAAfficher = lancementRecherche(listAlaetoire);

            }
        });

        //action  bouton si clique Afficher solution
        boutonAfficherReponse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listAlaetoire = reponseAffichage(RefAAfficher);
            }
        });


        //Action bouton pour changer de liste

        boutonChangerListe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listAlaetoire.clear();
                final String[] fonts = { Voca1, Voca10avril, VocaVerbeLivreAutres, VocaVerbeAutres, VocaVerbe,VocaELV2 ,VocaELV3, Voca8mai, VocaHira};

                //affichage popup choix de liste vocabulaire
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Selectionner une liste de vocabulaire");

                //construciton bourrine de l 'afficheage des listes de vocabulaire
                builder.setItems(fonts, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (Voca1.equals(fonts[which])){
                            Toast.makeText(MainActivity.this,"vous avez changer de liste", Toast.LENGTH_SHORT).show();
                            texteNomListeEncours.setText(Voca1);
                        }

                        else if (Voca10avril.equals(fonts[which])){
                            Toast.makeText(MainActivity.this,"vous avez changer de liste", Toast.LENGTH_SHORT).show();
                            texteNomListeEncours.setText(Voca10avril);
                        }

                        else if (VocaVerbeLivreAutres.equals(fonts[which])){
                            Toast.makeText(MainActivity.this,"vous avez changer de liste", Toast.LENGTH_SHORT).show();
                            texteNomListeEncours.setText(VocaVerbeLivreAutres);
                        }

                        else if (VocaVerbeAutres.equals(fonts[which])){
                            Toast.makeText(MainActivity.this,"vous avez changer de liste", Toast.LENGTH_SHORT).show();
                            texteNomListeEncours.setText(VocaVerbeAutres);
                        }

                        else if (VocaVerbe.equals(fonts[which])){
                            Toast.makeText(MainActivity.this,"vous avez changer de liste", Toast.LENGTH_SHORT).show();
                            texteNomListeEncours.setText(VocaVerbe);
                        }

                        else if (VocaELV2.equals(fonts[which])){
                            Toast.makeText(MainActivity.this,"vous avez changer de liste", Toast.LENGTH_SHORT).show();
                            texteNomListeEncours.setText(VocaELV2);
                        }

                        else if (VocaELV3.equals(fonts[which])){
                            Toast.makeText(MainActivity.this,"vous avez changer de liste", Toast.LENGTH_SHORT).show();
                            texteNomListeEncours.setText(VocaELV3);
                        }
                        else if (Voca8mai.equals(fonts[which])){
                            Toast.makeText(MainActivity.this,"vous avez changer de liste", Toast.LENGTH_SHORT).show();
                            texteNomListeEncours.setText(Voca8mai);
                        }
                        else if (VocaHira.equals(fonts[which])){
                            Toast.makeText(MainActivity.this,"vous avez changer de liste", Toast.LENGTH_SHORT).show();
                            texteNomListeEncours.setText(VocaHira);
                        }
                    }
                });
                builder.show();
            }
        });

    }


    //class correspond au clic sur mot suivant en prenant en compte le textview
    // avec le nom de la liste
    public int lancementRecherche(List listAlaetoire)
    {

        texteRomaji.setText("");
        texteHira.setText("");

        // pemret de selectionner la bonne liste en focntion de ce que texteNomListeEncours contient
        // Pas top du tout
        if ( texteNomListeEncours.getText() == Voca1) {
            listeRef= null;
            listeRef =    Vocabulaire1 ;
        }
        else if (texteNomListeEncours.getText() ==Voca10avril){
            listeRef= null;
            listeRef =    Vocabulaire10avril ;
        }

        else if (texteNomListeEncours.getText() ==VocaVerbeLivreAutres){
            listeRef= null;
            listeRef = VocaVerbeELVp62EtAutres ;
        }

        else if (texteNomListeEncours.getText() ==VocaVerbeAutres){
            listeRef= null;
            listeRef = VocaVerbeAutresListe ;
        }
        else if (texteNomListeEncours.getText() ==VocaVerbe) {
            listeRef = null;
            listeRef = VocaVerbeELVp57;
        }

         else if (texteNomListeEncours.getText() ==VocaELV2){
                listeRef= null;
                listeRef = VocaELVlecon2;
        }

        else if (texteNomListeEncours.getText() ==VocaELV3){
            listeRef= null;
            listeRef = VocaELVlecon3
            ;
        }

        else if (texteNomListeEncours.getText() ==Voca8mai){
            listeRef= null;
            listeRef = Voca8maiPerso;
        }

        else if (texteNomListeEncours.getText() ==VocaHira){
            listeRef= null;
            listeRef = vocaHiragana;
        }





        //appelle création liste de choix aléatoire des mots
       if (listAlaetoire.size()==0) {
            // creation liste et avertissement
           listAlaetoire = creationListeAlea(listeRef);
           }

        //affichage du nimbre de mot restant
        texteNboccurence.setText(String.format("Nombre de mot restant avec encours: " + Integer.toString(listAlaetoire.size())));
        int RefAAfficher = (Integer) listAlaetoire.get(0);

        //affichage du mot à toruver
        texteAfficher.setText(listeRef[RefAAfficher*3]);

        //on supprime le premier numéro de la liste des aléatoires
        // cela permettra de parcourir petit à petit la liste
        listAlaetoire.remove(0);
        return RefAAfficher;
    }

    //création liste des aléatoires
    private List creationListeAlea(String[] listeRef){
        // taille de la liste de vocabulaire de reference
        int j = listeRef.length /3;
        for (int i = 0; i < j; i++) {
            listAlaetoire.add(i);
        }

        // on mélange cette liste
        Collections.shuffle(listAlaetoire);


        //affichage fin de la liste
        Toast toast= Toast.makeText(MainActivity.this,"Nouvelle série", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

        return listAlaetoire;

    }

    //class action sur bouton Réponse
    private List reponseAffichage(int RefAAfficherK) {

        //affichage des réponses en romaji et kata et hira
        // modifier ici si on veut pas des romaji
        //avec romaji
        texteRomaji.setText(listeRef[RefAAfficherK*3+1]);

        // sans romaji
        //texteRomaji.setText("");
        texteHira.setText(listeRef[RefAAfficherK*3+2]);

    return listAlaetoire;

    }




}



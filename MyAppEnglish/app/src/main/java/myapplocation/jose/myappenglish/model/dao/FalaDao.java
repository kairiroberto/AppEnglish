package myapplocation.jose.myappenglish.model.dao;

import android.os.Environment;

import java.util.ArrayList;
import java.util.List;

import myapplocation.jose.myappenglish.model.Fala;

/**
 * Created by JOSE on 8-7-18.
 */

public class FalaDao {

    public static List<Fala> listarFalas() {

        List<Fala> myDataset = new ArrayList<Fala>();

        String diretorio = Environment.getExternalStorageDirectory().getPath().toString() + "/myAppEnglish/";

        String video1 = diretorio + "f1/f1-";
        myDataset.add(new Fala(1, 1, "Fala 1: Vaider: No I am your father. \n(Vaider: Não Eu sou o seu pai.)", video1 + "1.mp4"));
        myDataset.add(new Fala(2, 1, "Fala 2: Luke: No. No. No. That's not true. It's impossible. \n(Luke: Não. Não. Não é verdade. É impossível.)", video1 + "2.mp4"));
        myDataset.add(new Fala(3, 1, "Fala 3: Vaider: Listen your heart. You know it's true. \n(Vaider: Ouça o seu coração. Sabe que é verdade.)", video1 + "3.mp4"));
        myDataset.add(new Fala(4, 1, "Fala 4: Luke: No. No. \n(Luke: Não. Não.)", video1 + "4.mp4"));
        myDataset.add(new Fala(5, 1, "Fala 5: Vaider: Luke, you can destroy the Emperor. He already foresaw this. \n(Vaider: Luke, você pode destruir o Imperador. Ele já previu isso.)", video1 + "5.mp4"));
        myDataset.add(new Fala(6, 1, "Fala 6: Vaider: It is your destiny. Join me. \n(Vaider: É o seu destino. Junte-se a mim.)", video1 + "6.mp4"));
        myDataset.add(new Fala(7, 1, "Fala 7: Vaider: Together we can rule the galaxy as father and son. \n(Vaider: Juntos poderemos governar a galáxia como pai e filho.)", video1 + "7.mp4"));
        myDataset.add(new Fala(8, 1, "Fala 8: ... \n(...)", video1 + "8.mp4"));
        myDataset.add(new Fala(9, 1, "Fala 9: Vaider: Come with me. \n(Vaider: Venha comigo.)", video1 + "9.mp4"));
        myDataset.add(new Fala(10, 1, "Fala 10: Vaider: It's your only way out. \n(Vaider: É sua única saída.)", video1 + "10.mp4"));

        String video2 = diretorio + "f2/f2-";
        myDataset.add(new Fala(11, 2, "Fala 1: PETER: Ah! Nothing, it was nothing! \n(Ah! Nada, não foi nada!)", video2 + "1.mp4"));
        myDataset.add(new Fala(12, 2, "Fala 2: NED: You're Spider-Man! From YouTube. \n(Você é o Homem-Aranha! Do Youtube.)", video2 + "2.mp4"));
        myDataset.add(new Fala(13, 2, "Fala 3: PETER: I'm not! \n(Não sou!)", video2 + "3.mp4"));
        myDataset.add(new Fala(14, 2, "Fala 4: NED: You were on the ceiling! \n(Você estava no teto!)", video2 + "4.mp4"));
        myDataset.add(new Fala(15, 2, "Fala 5: PETER: I was not ... Ned what are you doing in my room ?! \n(Não estava... Ned o que está fazendo no meu quarto?!)", video2 + "5.mp4"));
        myDataset.add(new Fala(16, 2, "Fala 6: NED: You sent me an email, said we were going to finish the death star! \n(Você me mandou um e-mail, disse que íamos terminar a estrela da morte!)", video2 + "6.mp4"));
        myDataset.add(new Fala(17, 2, "Fala 7: PETER: Mr. Stark knows, he made my suit. But only this. \n(O Sr. Stark sabe, ele que fez meu traje. Mas só isso.)", video2 + "7.mp4"));
        myDataset.add(new Fala(18, 2, "Fala 8: NED: Did Tony Stark do this to you? Are you one of the Avengers? \n(Tony Stark te fez isso? Você é um dos Vingadores?)", video2 + "8.mp4"));
        myDataset.add(new Fala(19, 2, "Fala 9: PETER:  Yeah, basically. (É, basicamente.)", video2 + "9.mp4"));
        myDataset.add(new Fala(20, 2, "Fala 10: ... \n(...)", video2 + "10.mp4"));

        String video3 = diretorio + "f3/f3-";
        myDataset.add(new Fala(21, 3, "Fala 1:Roy Batty: I saw things people would not believe. Ships of attack burning in the frontiers of Orion. I saw C-rays flickering in the darkness by the Tannhauser Portal. All these moments will be lost in time like tears in the rain. \n(Eu vi coisas que as pessoas não acreditariam. Naves de ataque ardendo em chamas nas fronteiras de Orion. Eu vi Raios-C cintilando na escuridão junto ao Portal de Tannhauser. Todos esses momentos vão se perder no tempo como lágrimas na chuva)", video3 + "1.mp4"));
        myDataset.add(new Fala(22, 3, "Fala 2: ... \n(...)", video3 + "2.mp4"));
        myDataset.add(new Fala(23, 3, "Fala 3: Roy Batty: Time to die. \n(Hora de morrer)", video3 + "3.mp4"));
        myDataset.add(new Fala(24, 3, "Fala 4: ... \n(...)", video3 + "4.mp4"));

        String video4 = diretorio + "f4/f4-";
        myDataset.add(new Fala(25, 4, "Fala 1: Ludendorff: What a surprise. Strange ... Unfortunately, I have another subject to take care of. What are you? \n(Que surpresa. Estranho... Infelizmente, tenho outro assunto para cuidar. O que é você?)", video4 + "1.mp4"));
        myDataset.add(new Fala(26, 4, "Fala 2: Dianna: Soon you'll find out. \n(Logo você decobrirá.)", video4 + "2.mp4"));

        String video5 = diretorio + "f5/c1/f5.1-";
        myDataset.add(new Fala(27, 5, "Fala 1: Tim Thomas: You look great. \n(Você está ótima.)", video5 + "1.mp4"));
        myDataset.add(new Fala(28, 5, "Fala 2: Holly Apelgren: Am I? I feel great. How are you? \n(Estou? Eu me sinto ótima. Como você está?)", video5 + "2.mp4"));
        myDataset.add(new Fala(29, 5, "Fala 3: Tim Thomas: I'm fine. I need a favor. \n(Eu estou muito bem. Preciso de um favor.)", video5 + "3.mp4"));
        myDataset.add(new Fala(30, 5, "Fala 4: Holly Apelgren: Whatever you want, just ask me. \n(O que você quiser, é só me pedir.)", video5 + "4.mp4"));
        myDataset.add(new Fala(31, 5, "Fala 5: Tim Thomas: I need a name. Someone in the system. Someone who is going through difficult times. That you need help, but be very proud to ask. \n(Eu preciso de um nome. Alguém no sistema. Alguém que está passando por termpos díficeis. Que precise de ajuda, mas seja muito orgulhoso para pedir.)", video5 + "5.mp4"));
        myDataset.add(new Fala(32, 5, "Fala 6: Holly Apelgren: What are you doing? \n(O que você está fazendo?)", video5 + "6.mp4"));
        myDataset.add(new Fala(33, 5, "Fala 7: Tim Thomas: I'm helping. I need a name. \n(Estou ajudando. Eu preciso de um nome.)", video5 + "7.mp4"));
        myDataset.add(new Fala(34, 5, "Fala 8: Holly Apelgren: Right. \n(Certo.)", video5 + "8.mp4"));

        String video6 = diretorio + "f5/c2/f5.2-";
        myDataset.add(new Fala(35, 6, "Fala 1: Tim Thomas: Here's my card. If anyone on the Recipe calls you, call me right away! \n(Aqui está meu cartão. Se alguém da Receita te ligar, ligue para mim, imediatamente!)", video6 + "1.mp4"));
        myDataset.add(new Fala(36, 6, "Fala 2: Emily Posa: Right. Thanks. \n(Certo. Obrigada.)", video6 + "2.mp4"));
        myDataset.add(new Fala(37, 6, "Fala 3: Tim Thomas: Thank you. All right then. \n(Eu que agradeço. Então tá.)", video6 + "3.mp4"));
        myDataset.add(new Fala(38, 6, "Fala 4: Emily Posa: Mr. Thomas? Why do I get the impression that you're doing me a huge favor? \n(Sr. Thomas? Por que eu tenho a impressão de que você está me fazendo um enorme favor?)", video6 + "4.mp4"));
        myDataset.add(new Fala(39, 6, "Fala 5: Tim Thomas: Because I get the impression that you really deserve it. \n(Porque eu tenho a impressão de que você realmente merece.)", video6 + "5.mp4"));
        myDataset.add(new Fala(40, 6, "Fala 6: Emily Posa: ... \n(...)", video6 + "6.mp4"));

        String video7 = diretorio + "f5/c3/f5.3-";
        myDataset.add(new Fala(41, 7, "Fala 1: Tim Thomas: Focus! Do what you promised me! \n(Concentre-se! Faça o que me promoteu!)", video7 + "1.mp4"));
        myDataset.add(new Fala(42, 7, "Fala 2: Dan: Dan: You think ... You think I'm going to disappoint you, right? I've known you all my life, damn it! Right? That, this ... This is not something you do every day. You see? This is not easy for me. I'll make sure everything goes as planned. Do not worry. \n(Você acha que... Você acha que eu vou te decepcionar, né? Eu te conheço a minha vida inteira, porra! Certo? Isso, isso... Isso não é uma coisa que se faz todo dia. Entende? Isso não é fácil para mim. Vou me certificar que tudo siga o planejado. Não se preocupe.)", video7 + "2.mp4"));

        return myDataset;
    }

    public static List<Fala> listarFalasIdCena(int id) {
        List<Fala> myDataset = new ArrayList<Fala>();
        for (Fala f : listarFalas()) {
            if (f.getCena() == id) {
                myDataset.add(f);
            }
        }
        return myDataset;
    }

}

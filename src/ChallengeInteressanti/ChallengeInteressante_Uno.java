package ChallengeInteressanti;

import java.util.HashMap;

public class ChallengeInteressante_Uno {
    public static void main(String[] args) {


//        A: 4, /\, @, /-\, ^, ä, ª, aye, ∂, Fl, O, Δ, Λ
//        B: 8, 6, 13, |3, ß, P>, |:, !3, (3, /3, )3, Б, б
//        C: [, ¢, <, (, ©
//        D: |), o|, [), I>, |>, ?, T), /), Д, |7, 7
//        E: 3, &, £, ë, [-, €, ê, |=-, Ξ, Σ, ε
//        F: 4, |=, ƒ, |#, i=, ph, /=, =
//        G: 6, &, (_+, 9, C-, gee, (γ, б,
//                H: 4, #, /-/, [-], ]-[, )-(, (-), :-:, |~| {=}, <~>, |-|, ]~[, }{ , ]-[, ?, }-{, Ю
//        I: 1, !, |, &, eye, 3y3, ï, ][, [], ¡
//        J: _|, ;, _/, </, (/, ¿
//        K: X, |<, |{, ]{, }<, /< , |(, Ж
//            L: 2, £, 7, 1_, |, |_, #, l, i, \_
//            M: M, m, //., |v|, [V], {V}, |\/|, /\/\, (u), []V[], (V), (\/), /|\, Μ, М, м, /V\,
//             N: //, ^/, |\|, |/|, /\/, [\], , <\>, {\}, []\[], И, n,/V, ₪, Й
//            O: 0, (), ?p, [], *, ö, Ø, Ө, Ф, 9
//            P: |^, |*, |o, |º, |^(o), |>, |", 9, []D, |̊, |7 |°, ?
//            Q: [,], (_,), ()_, 0_, <|, O-, Ø, Ф
//            R: |2, P\, |?, /2,|^, lz, ®, [z, 12, Я, 2, |>\
//            S: 5, 2, $, z, §, ehs, es
//            T: 7, +, -|-, 1, '][', "|", †, ₮
//            U: (_), |_|,|.|, v, ü Ü, Ц, V
//            V: \/, \_/, \./
//            W: \/\/, vv, '//, \^/, (n), \V/, \//, \X/, \|/, \_|_/, \_:_/, \x/, I_l_I, Ш, VV
//            X: ><, Ж, }{, )(, ×
//            Y: '-/, j, `/, \|, Ý, ÿ, ý, Ŷ, ŷ, Ÿ, Ϋ, Υ, Ψ, φ, λ, Ұ, ұ, ў, ץ ,צ, -), Ч, ¥
//            Z: 2, ~\_, ~/_,7_, %, Σ
        HashMap<Character,String> vocabolario = new HashMap<>();
        vocabolario.put('a',"4");
        vocabolario.put('b',"ß");
        vocabolario.put('c',"¢");
        vocabolario.put('d',"ᶑ");
        vocabolario.put('e',"3");
        vocabolario.put('f',"ᚪ");
        vocabolario.put('g',"б");
        vocabolario.put('h',"ᚻ");
        vocabolario.put('i',"1");
        vocabolario.put('j',"j");
        vocabolario.put('k',"|{");
        vocabolario.put('l',"Ł");
        vocabolario.put('m',"ᛖ");
        vocabolario.put('n',"ᚤ");
        vocabolario.put('o',"0");
        vocabolario.put('p',"ᚹ");
        vocabolario.put('q',"Ø");
        vocabolario.put('r',"Я");
        vocabolario.put('s',"ᛢ");
        vocabolario.put('t',"7");
        vocabolario.put('u',"Ц");
        vocabolario.put('v',"Ꝟ");
        vocabolario.put('w',"Ш");
        vocabolario.put('x',"Ж");
        vocabolario.put('y',"Ψ");
        vocabolario.put('z',"Σ");
        System.out.println(vocabolario.values());

        String[] nomi = {"Gubru", "Cesare", "Mirco", "Vincenzo", "Michele", "Stefano", "Francesco", "Juan", "Wang", "Armando"};
        for(String s : nomi) {
            StringBuilder sb = new StringBuilder();
            char[] lettere = s.toCharArray();
            for (char c : lettere) {
                sb.append(vocabolario.get(Character.toLowerCase(c)));
            }
            System.out.println(s + " = " + sb);
        }




    }
}

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;


public class Auto_tester {

    public void text_all_texts() throws IOException {
        System.out.println("entrei aqui");
        Test t=new Test();
        System.out.println("iniciei test");
        PrintWriter pw = new PrintWriter(new File("test_results.csv"));
        PrintWriter pw2 = new PrintWriter(new File("test_results_neural_net.csv"));
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        //FILE FOR EVERYONE
        sb.append("total_words");
        sb.append(';');
        sb.append("total_sentences");
        sb.append(';');
        sb.append("total_syllables");
        sb.append(';');
        sb.append("complex_words");
        sb.append(';');
        sb.append("letter_count");
        sb.append(';');
        sb.append("common_words");
        sb.append(';');
        sb.append("total_different_words");
        sb.append(';');
        sb.append("different_advanced_words");
        sb.append(';');
        sb.append("flesch_reading_ease");
        sb.append(';');
        sb.append("flesch_kinkaid");
        sb.append(';');
        sb.append("gunning_fog");
        sb.append(';');
        sb.append("coleman_liau");
        sb.append(';');
        sb.append("smog_grade");
        sb.append(';');
        sb.append("automated_readibility_index");
        sb.append(';');
        sb.append("lexical_density");
        sb.append(';');
        sb.append("beyond_2000");
        sb.append(';');
        sb.append("advanced_ttr");
        sb.append(';');
        sb.append("advanced_guiraud");
        sb.append(';');
        sb.append("ttr");
        sb.append(';');
        sb.append("rttr");
        sb.append(';');
        sb.append("cttr");
        sb.append(';');
        sb.append("m");
        sb.append(';');
        sb.append("h");
        sb.append(';');
        sb.append("s");
        sb.append(';');
        sb.append("u");
        sb.append(';');
        sb.append("mwf");
        sb.append(';');
        sb.append("r");
        sb.append(';');
        sb.append("bigram_model");
        sb.append(';');
        sb.append("bigram_perplexety");
        sb.append(';');
        sb.append("a1_words");
        sb.append(';');
        sb.append("a2_words");
        sb.append(';');
        sb.append("b1_words");
        sb.append(';');
        sb.append("b2_words");
        sb.append(';');
        sb.append("c1_words");
        sb.append(';');
        sb.append("c2_words");
        sb.append(';');
        sb.append("bigram_model_reverse");
        sb.append(';');
        sb.append("bigram_perplexety_reverse");
        sb.append(';');
        sb.append("words_per_sentence");
        sb.append(';');
        sb.append("sentences_per_paragraph");
        sb.append(';');
        sb.append("simple_errors_per_word");
        sb.append(';');
        sb.append("complex_errors_per_word");
        sb.append(';');
        sb.append("level");
        sb.append('\n');

        //FILE FOR NEURAL NET
        sb2.append("level");
        sb2.append(';');
        sb2.append("total_words");
        sb2.append(';');
        sb2.append("total_sentences");
        sb2.append(';');
        sb2.append("total_syllables");
        sb2.append(';');
        sb2.append("complex_words");
        sb2.append(';');
        sb2.append("letter_count");
        sb2.append(';');
        sb2.append("common_words");
        sb2.append(';');
        sb2.append("total_different_words");
        sb2.append(';');
        sb2.append("different_advanced_words");
        sb2.append(';');
        sb2.append("flesch_reading_ease");
        sb2.append(';');
        sb2.append("flesch_kinkaid");
        sb2.append(';');
        sb2.append("gunning_fog");
        sb2.append(';');
        sb2.append("coleman_liau");
        sb2.append(';');
        sb2.append("smog_grade");
        sb2.append(';');
        sb2.append("automated_readibility_index");
        sb2.append(';');
        sb2.append("lexical_density");
        sb2.append(';');
        sb2.append("beyond_2000");
        sb2.append(';');
        sb2.append("advanced_ttr");
        sb2.append(';');
        sb2.append("advanced_guiraud");
        sb2.append(';');
        sb2.append("ttr");
        sb2.append(';');
        sb2.append("rttr");
        sb2.append(';');
        sb2.append("cttr");
        sb2.append(';');
        sb2.append("m");
        sb2.append(';');
        sb2.append("h");
        sb2.append(';');
        sb2.append("s");
        sb2.append(';');
        sb2.append("u");
        sb2.append(';');
        sb2.append("mwf");
        sb2.append(';');
        sb2.append("r");
        sb2.append(';');
        sb2.append("bigram_model");
        sb2.append(';');
        sb2.append("bigram_perplexety");
        sb2.append(';');
        sb2.append("a1_words");
        sb2.append(';');
        sb2.append("a2_words");
        sb2.append(';');
        sb2.append("b1_words");
        sb2.append(';');
        sb2.append("b2_words");
        sb2.append(';');
        sb2.append("c1_words");
        sb2.append(';');
        sb2.append("c2_words");
        sb2.append(';');
        sb2.append("bigram_model_reverse");
        sb2.append(';');
        sb2.append("bigram_perplexety_reverse");
        sb2.append(';');
        sb2.append("words_per_sentence");
        sb2.append(';');
        sb2.append("sentences_per_paragraph");
        sb2.append(';');
        sb2.append("simple_errors_per_word");
        sb2.append(';');
        sb2.append("complex_errors_per_word");
        sb2.append('\n');

        for(String s:a1){
            t.run_test(s);
            sb2.append("1;");
            sb2.append(t.print_test()+"\n");
            sb.append(t.print_test());
            sb.append(";1\n");
        }
        for(String s:a2){
            //System.out.println("New test");
            t.run_test(s);
            sb2.append("2;");
            sb2.append(t.print_test()+"\n");
            sb.append(t.print_test());
            sb.append(";2\n");
        }
        for(String s:b1){
            t.run_test(s);
            sb2.append("3;");
            sb2.append(t.print_test()+"\n");
            sb.append(t.print_test());
            sb.append(";3\n");
        }
        for(String s:b2){
            t.run_test(s);
            sb2.append("4;");
            sb2.append(t.print_test()+"\n");
            sb.append(t.print_test());
            sb.append(";4\n");
        }
        for(String s:c1){
            t.run_test(s);
            sb2.append("5;");
            sb2.append(t.print_test()+"\n");
            sb.append(t.print_test());
            sb.append(";5\n");
        }
        for(String s:c2){
            t.run_test(s);
            sb2.append("6;");
            sb2.append(t.print_test()+"\n");
            sb.append(t.print_test());
            sb.append(";6\n");
        }

        pw.write(sb.toString());
        pw.close();
        pw2.write(sb2.toString());
        pw2.close();
        System.out.println("done!");
    }




    private List<String> a1= Arrays.asList("Yesterday Tom had his breakfast. He then went for a walk with his dog and some friends. After the walk they had a picnic. Everybody had a good day. In the evening Tom was tired and went to bed.\n");

    private List<String> a2= Arrays.asList("Hello,\n" +
            "I am from London. There are much reasons why I would like to join to your internet forum. Firstly, for example I’ve seen few good download links for movies, music, softwares and others. Secondly I like that everything what I need is at one forum. You know, I am studying high school of telecommunication and everything about computers is my hobby too.\n" +
            "I want ask how many members can be in this internet forum?\n" +
            "Thanks for your answer.\n","I have many time at weekends so I am helping my mom with much houseworks. \n" +
            "Firstly we are going to nearby supermarket for some vegetable and fresh meat. After the shopping at home I am making a tasty lunch. After lunch in the afternoons I am helping at garden. Every time I am washing our dirty car and my mom is taking care about flowers. After that I am cleaning the tile floor in house and my mom is going to the laundry with some dirty clothes.\n" +
            "In the evening everything is perfect. So we are very happy. \n","Hi Sara,\n" +
            "I am writing you a quick email because I will miss the English lesson Friday. It is my boyfriend’s birthday, and I have booked a table at a great restaurant. \n" +
            "I would like to ask your help. The teacher always gives us a lot of handouts. Could you ask for a copy for me. I will try to do all the work at the weekend.\n" +
            "Can I come to your flat on Saturday morning for a coffee and to pick up the handouts - and to have a chat. \n" +
            "Lots of love, \n" +
            "Bridget\n","Hi Rikardo, \n" +
            "What a shame. You missed my birthday party. I know you had a good reason: you were working on the other side of the country and couldn’t travel home for it. \n" +
            "Anyway, we had a great time. We all met up for a drink at the Golden Eagle and then went on to Mazzi’s that new restaurant in the centre of town. After that we moved on to a bar.\n" +
            "When are you coming home? We should meet up soon. \n" +
            "Love, \n" +
            "Lorna\n");

    private List<String> b1= Arrays.asList("Hello Pedro ,\n" +
            "Thank you for your letter. It was wonderful to hear from you again. I like to run and we can run in the park every day. But we can travel to the village and we can run on the meadow at the weekend.\n" +
            "I think you will feel good in my town because you like to do sport. We have to go in the new sporthall because I want to show a new football field to you.\n" +
            "I like to watch the football game on the TV but I have visited the basketball match. I play in the volleyball team of the town. I like to swim in Balaton in my freetime. I enjoy the sport and I want to life on healthy.\n" +
            "You can find tennis field, swimming pool, a lot of gym in the town. You can run in the park and you will injoy because there are fresh air. I would like to run with you and we can run on the meadow close to town.\n" +
            "I hope we will fell good in sommer.\n" +
            "Wriete me soon. Love Zsofi\n","Dear Pedro ,\n" +
            "I must write to you because last week I saw a new film… in the cinema. I have gone with my friends to the cinema because I wanted to see the new film of my favorite director. He is George Lucas. The film takes place in the future. This is a sci-fi.\n" +
            "I know you hate the sci-fi but you have to see this film because it is very exiting and scaring.\n" +
            "I was afraid in the cinema because the film was rather noisy. You have to see in the cinema because you will not enjoy on TV. You have to invite somebody to the film because you will be afraid alone.\n" +
            "You can see a new planet, knights and lot of master. You have to see the film because you will like the music of the film.\n" +
            "Well that is all for now.\n" +
            "Love Zsofi\n","Hi Andreo,\n" +
            "I am writing you a quick email because I have just seen an excellent film and I would be happy to see it again with you next week if you want. \n" +
            "The film is “Lost Lives” and is about several young people who can’t find work and quarrel with their parents. It’s so realistic and different from the American rubbish that you usually see at the cinema. \n" +
            "Let me know if you want to see it, when we meet tomorrow at Lila’s place. \n" +
            "Lots of love,\n" +
            "Bridget\n","Hi Rikardo, \n" +
            "Fantastic news! I didn’t win the jackpot but I got EUR 5000 from that lottery ticket I bought while we were on holiday. \n" +
            "I’ve already spent about half of it. For the first time in my life I don’t owe the bank any money. I’ve also bought new shoes for the winter and a coat. You will have to see them when we meet up. \n" +
            "But as I bought the lottery ticket while we were on holiday at lake Grenberg, I would like to go there again with you and stay in a five star hotel. What do you think? When are you free?\n" +
            "Love, \n" +
            "Lorna\n","Dear Zara , \n" +
            "My family is visiting London next month from 13th – 20th December . I would love to meet you while I am in London . My dad is taking me and my brother to London zoo on Saturday 15th December . Why don’t you come too ? It would be great to see you again . \n" +
            "Love,\n" +
            "Pedro\n","Dear James , \n" +
            "Thank you for your letter , which came yesterday . It’s always good to hear from you . \n" +
            "I play the guitar quite a lot . I am not very good but I enjoy it . I often go to my friend's house and we play together . I don't go to many concerts as I live in a small town and not many bands come here . At parties we often dance and I like that ! I like rock and roll music best . I listen to a lot of music on my mp3 player . I have usually got it with me . \n" +
            "What about you ? Do you play an instrument ? \n" +
            "Write soon,\n" +
            "Pedro\n");

    private List<String> b2= Arrays.asList("Dear Pedro , \n" +
            "I was greatly surprised when I heard that you are going to work overseas for such a long time. I was greatly surprised when I heard that you are going to work overseas for such a long time. You have to know that I will miss you, but I’m glad that you would like to keep in touch with your relatives, especially your grandparents. It’s nice to hear that you ask my opinion about teaching them how to use the computer, so I tried to write down some important things, here it is. \n" +
            "As you know, electronic communication, such as e-mail or skype has advantages and disadvantages too. \n" +
            "About the advantages: if you want to tell something very important to somebody, you don’t need to go to the post office to send a letter and wait for days to get the answer, just access the Internet and that’s it. I know that there is an other option, which is a mobile phone, but what if the person switched it off? So, the Internet is fast, and you don’t have to pay so much money for it, e.g.: you can write an e-mail in an Internet caffe too. But on the other hand, it’s possible that the computer beaks down or catch a a virus, or there is no electricity in your town. \n" +
            "You can ask an important question: how these elderly people could learn the use of modern electronic devices? My answer is, that you should show them how to call people with a mobile phone (just press the green button) or write an e-mail with a computer. After it, it’s necessary to practise these two tasks before you have, to remember the method of calling a person or writing an e-mail. Of course you can write down the steps on a piece of paper, in this way they can make it without you. \n" +
            "In my opinion, teenagers use the computer usually, because with the help of the computer they can play computer games, listen to music, read an electronic book, chat with their friends and collect lots of imformation that is necessary because of a homework. I think that elderly people don’t use the computer usually, because they don’t care about it, they don’t have the skills in this modern world to use it, but there are some people of old age who want to learn how to use it. \n" +
            "Because of this, we have to teach them to use it. I think that a person can live without modern electronic devices, like our relatives in the past, but we live in a modern world and we have to keep steps with our technology, because if we not, we are going to be stupid people after a little time.\n" +
            "I hope that I could help you with my ideas, please let me hear from your grandparents after you leave. I look forward to hearing from you! \n" +
            "Best wishes, Klaudia\n","Dear Mr Williams , \n" +
            "I saw your advertisement for language courses in London and I am writing to find out more about the courses you offer . I am thinking of attending a course for two or three weeks in August . Could you please send me more information and details of prices ? \n" +
            "I would particularly like to know how many students attend the school , and how many students there are in a class . I'd also like to know what resources the school has . For example , is there a library where I can study in the evenings ? Could you tell me something about the staff ? Are they all qualified teachers ? \n" +
            "I would be interested in having more details of the social and sports \n" +
            "programme . Are the activities included in the price of the course ? Could you tell me about the cost of accommodation too ? \n" +
            "Also , can you tell me what amenities there are near the school ? For \n" +
            "example , is there a park or cinema nearby ? \n" +
            "I look forward to receiving your reply . \n" +
            "Regards ,\n" +
            "Pedro\n","Exeter has a comprehensive selection of sports and leisure facilities . These include sports centres , running tracks , indoor bowling greens , a golf course and a driving range as well as swimming pools , sports pitches and an artificial turf pitch . Tennis courts are available in many of the public  parks , and are free to use . \n" +
            "The main swimming pool in Exeter has recently been renovated and is now very attractive . A fitness centre and sauna are also available . There is an open-air swimming pool for use in the summer months . \n" +
            "The local countryside provides the perfect opportunity for horse-riding , which needs to be booked in advance . There are many lovely walks on the nearby \n" +
            "hills . Cycling in Exeter is popular both as a recreational activity and as a convenient way of getting to work or the shops .\n","I would like to share my opinion. Recently it has become more important to me…… \n" +
            "because I finally want to live a healthy long life, so I went on a diet, this was the first step, and it is not easy, but I will not give it up. \n" +
            "In my country which is Hungary there are so many dietary habits to loose weight, people find out lots of crazy diets, but the wellknown is that you should eat five times in a day, and little portions, drink two or three liter water, fruits and vegetables as much as you can, and do whatever sports from running to swimming. \n" +
            "I may say that the Hungarian dishes likely contain a lot of fat, because we eat meat with meat, rice, potato and little fruits and vegetables. Well, it is not so healthy. As far as I am concerned, I do not like the Hungarian cuisine, there are a few dishes that I like, but usually I do not eat Hungarian dishes. \n" +
            "There are other kinds of food that I can not stand which is frozen or oven-ready meals. It is not healthy at all, people buy it because they want to eat something and they do not have much time, but this is the only advantage of frozen food. I always try to have time to make some food for myself, it can be a simple sandwich or a soup.\n" +
            "There is a difficult question and it is hard to decide to cook something at home or eat something in a restaurant. I like eating in a restaurant because there is a friendly atmosphere, delicious dishes, appropriate service. But I do not have time to relax and go to an Italian restaurant (which my favourite by the way), and unfortunately, money is an important reason for me, because there are many expensive restaurants and I can not find a cheaper one in my town. So instead of eating out, I cook something at home and I imagine that I am in a famous restaurant.\n" +
            " In my opinion, diet is a good way to keep our body in a better condition, and if we choose a proper diet with sense we are able to live a happy and long life without illnesses and diseases with our loved ones. If we are lucky and successful, we can teach our friends how to do a diet and how to stay healthy.\n" +
            "I hope that with this comment I could help for many readers, all my advice is when you choose a diet, listen to your common sense!\n","Dear Sir / Madam, \n" +
            "I have your advertisement for three flats in the Grenberg area. \n" +
            "My client, Jana Wolski, is interested in renting the 100 square metre attic in the centre of the town to accommodate both herself and her university sculpture work. \n" +
            "I can see the rent is EUR 950 per month, but I would also like to know if a deposit is payable and if so how much. I assume the flat is currently vacant and that the tenant can move in immediately. \n" +
            "Jana would also like to inspect the flat. I wonder if that could be arranged for next Thursday at 10.30. I would be grateful if you could send me the exact address. \n" +
            "Jill Pipes \n" +
            "Accommodation Office \n" +
            "Grenberg University\n","The Golden Eagle pub on the Meckham Road has finally closed its doors to business after more than eighty years. \n" +
            "The last night, Saturday, saw a full house. Over two hundred people turned up for a last drink with the party mood spilling out onto the pavement. \n" +
            "The closure was confirmed by the licensing committee of Grenberg City Council last month even though a thousand-strong petition against closure had been handed in by local residents. The committee sought the closure after repeated warnings about noise had gone unheeded. \n" +
            "Reactions in the neighbourhood were understandably mixed. Long term local resident, eighty-year-old Jack Hemmingway said, “A very sad day indeed, I had my first drink in there when I was fourteen in 1946.” \n" +
            "But others welcomed the closure. Rebecca Gold, an office manager, said, “I sometimes could not get to sleep till after midnight because of the noise. I was falling asleep at work.”\n" +
            "Planning permission has been given to turn the building into three residential flats.\n","Beyond the Graves by Rudolph Duvall was the first adult play which I saw at the age of twelve. It is also one of the best plays ever written, so I was eager to see Brian Smith’s rendition which had its first performance in the Grenberg State Theatre last Friday.\n" +
            "The play features a nineteenth century family torn apart by the competing claims of modernity and tradition. Gertrude, the only daughter of the rich farming family, wants not to marry, to live in the town and to study art. The relations between Gertrude, her parents, brothers and friends are intricate and delicate.\n" +
            "I was horrified, therefore, to see Smith portray these touching and difficult matters in the form of a comedy. Even in its own terms the comedy failed as Sarah Jenner, Playing Gertrude, is no comedy actress. In the end the play fell flat; and one could feel the wave of confusion and disappointment in the auditorium. \n" +
            "A disappointment indeed! \n","“People in all countries are fundamentally the same.” \n" +
            "The core physiological and mental make up of all human beings are the same, but the values and behaviour of people are moulded by different cultural histories.\n" +
            "Many of the structures that determine human life and behaviour are not within the power of human beings to change. Our physical capacities (e.g. we can walk but not fly), our need to live in communities, and our capacity for language are fixed. Even areas like differences between men and women and the themes in literature have a fixed pattern across societies over time. \n" +
            "Yet, society and technology do mould people. The way people live and think today in the twenty-first century is different from that of the nineteenth. The role and relationship between men and women have changed, the structure of families has changed. \n" +
            "In conclusion, similarities there are, but also differences between countries, within countries and over time.\n","Dear Recruitment Administrator, \n" +
            "I have recently seen your advertisement for an office manager on the internet recruitment site ProfNow. com. I am interested in applying for the position. \n" +
            "I have enclosed my CV for your perusal, but I would like to highlight a few points. I have a relevant degree and have practical experience of managing a small company. I speak English well and have a basic command of German. \n" +
            "I live in the area and could start work immediately. \n" +
            "I would be grateful if you could consider my candidature and call me for interview at your convenience. \n" +
            "Yours faithfully, \n" +
            "Edwina Smith \n","Shoes4U is experiencing a rapid upswing in sales this year, confounding critics who claim that shoe manufacturing can no longer succeed in a high wage economy. \n" +
            "The main mass production Hart shoe factory closed in Meckham over a quarter of century ago in 1983. It simply couldn’t compete with cheap manufacture in Asian and other low wage economics. But left behind was a wealth of experience in shoe making. \n" +
            "Leo Bernard had just finished his apprenticeship in 1983 when the factory closed. Though made redundant, he started making fashion shoes in his flat and began experimenting with design. “I couldn’t make a living from handmade shoes, but I was learning fast,” says Leo.\n" +
            "He built up his business slowly and carefully. “Training and personal responsibility were the key. I chose the right people and trained them well. Everybody was on flexible contracts.”\n" +
            "And today Shoes4U employs twenty people and has a turnover in the millions. “It’s all about finding a niche and remorselessly exploiting it,” Leo insists. \n" +
            "Perhaps other entrepreneurs should follow Leo Bernard’s advice.\n","Dear Sir/Madam, \n" +
            "On Friday 22 March two of my employees, as part of their work duties, took the 897 InterRegio bus (13.06 departure) from Grenberg to Meckham. I have two serious complaints with the service. \n" +
            "First, the bus was thirty-five minutes late, apparently due to the difficulties in finding a substitute after the scheduled driver telephoned in sick. Second, in an attempt to make-up time, the driver, without any announcement to the passengers, by-passed Meckham on the motorway. My two employees had no option other than to take a taxi back to Meckham. \n" +
            "As a result of this poor service my employees were not able to attend a crucial business meeting which resulted in financial loss. \n" +
            "I request from you a formal apology, and an offer of compensation. \n" +
            "Yours sincerely, \n" +
            "Leo Bernard\n","A strong corporate culture can indeed help a firm prosper. But much will depend on the content of that culture. \n" +
            "Undoubtedly, the core to corporate success is economic not cultural. Success is a matter of having a product in the market and being able by means of the right capital outlay to minimise costs and maximise revenue. The ideas which concern the production process – or the organisation of a service – are for the most part of a technical nature. So what kind of space is left for corporate culture? \n" +
            "A corporate culture bears not on technology but on the company’s employees. An effective culture can give the employee a sense of worth and purpose, thus leading to higher levels of loyalty and productivity. It is nonetheless possible to imagine strong actually existing cultures in a company which are dysfunctional. \n" +
            "In conclusion strong corporate structures can help a firm succeed, but not necessarily so.\n","Dear Charity Committee,\n" +
            "I’d prefer to support a Charity for Leopards. Leopards are amazing and\n" +
            "beautiful animals. They can run extremely fast, are wonderful hunters and\n" +
            "manage to catch smaller animals by hiding in the trees at night. They are\n" +
            "powerful. I’d rather support leopards because they are related to animals\n" +
            "like lions and tigers and only sometimes hurt people. They can survive in\n" +
            "water and eat fish, so I think it is easy to help them.\n" +
            "I am not in favour of supporting a charity for Giant Pandas or Elephants\n" +
            "due to the fact that Giant Pandas and Elephants get a lot of publicity in\n" +
            "the world. There are many charities for Elephants and Pandas and zoos\n" +
            "look after pandas and many people go to the zoo and give money for\n" +
            "pandas. I wouldn’t support Blue Whales because they eat tons of krill and\n" +
            "this means that other ocean animals have less food.\n" +
            "With best wishes,\n" +
            "Barbara Plum\n","Dear Santiago\n" +
            "I have just heard that you want to leave the family legal business to go\n" +
            "and follow your own career.\n" +
            "As you know your family are upset with this decision as they had always\n" +
            "thought it would be you to carry on the family firm. I know the family\n" +
            "business takes up so much time. It must be tempting to go and do your\n" +
            "own thing so you can feel more independent and meet more people in a\n" +
            "larger workplace.\n" +
            "However, have you really considered the advantages of continuing the\n" +
            "family firm? It’s wonderful to be able to work with those nearest to you\n" +
            "that you can really trust. Also there is a real sense of pride and\n" +
            "satisfaction in keeping up the family reputation.\n" +
            "Did you know that 65% of all businesses are family ones but only 3% of\n" +
            "these businesses make it to a fourth generation? Just imagine how proud\n" +
            "you would be if you could pass on the business to your children!\n" +
            "I hope I can persuade you to change your mind.\n" +
            "Your friend\n" +
            "Esmeralda\n");

    private List<String> c1= Arrays.asList("In my essay I’d like to write about my opinion and change after my ERASMUS life in Norway. To my mind usually people dream about abroad but they are afraid to do something to take a step to move and they just act tourist but never try to work. Hungarians are skeptical against “dreams”.\n" +
            " I was lucky and chosen (the only one student from Hungary) who got a place in a small town in Norway, Halden to study. Norway is a colorful country with many migrants. Nowadays I heard from Norwegians that they personally do not really accept immigrants anymore, because they are “stealing” the jobs away. To my mind students are rather those people, who are enough brave to risk a travel and living – to try to start a new life abroad.\n" +
            "There is not just only one opportunity to move abroad. Also a work-exchange is possible. It’s chooseable: either 1 or 3 years you can choose. In Halden I became real good friends with some Italian, Swiss, American and Japanese doctors at an international “Reactor Project”. Usually exchange-workers are around the age of 30. \n" +
            "Actually foreigners have stereotypes about incoming workers. However Norwegians are quite intelligent – everyone speaks English like a native – they do not really know about Hungary. But at least we are not muslims and do come from Europe – we are accepted there. \n" +
            "I think if someone did at least a year abroad, it also might high up the level of his/her intelligence – that’s why they have more chances to get or to keep a job. \n" +
            "Language is a quite important part of the globalization. If someone can talk in a main language (English, German, Spanish, etc.) and in addition some in small ones (Hungarian, Finnish, tc.) he or she has much more chances at every field of (global) work. \n" +
            "Hungary always had the chance for exchange as a student: earlier in the Sowyet Union, now almost on the whole Earth. With the European Union and the Shengen we also have the opportunity for an exchange work of internship. \n" +
            "I feel lucky with my start of life: my mother tounge is German, I learned Hungarian in the kindergarten and I became addicted to languages, started to learn Finnish and English, I moved to Norway and I learned Norwegian there. Now I speak 4 languages fluently and one (Finnish) just on the basic level. If someone makes a time abroad, he/she is going to be open for other languages and cultures. This point we’ve got to highlight well, because multiculturism just started recently – and it ain’t stop. \n","In my journal today I’m going to write about my opinion about a topic (after a webpage) about potential virtual schools in the following century. \n" +
            "As I was learning at the elementary school, teachers always forced us to work in teams. I never liked it – it did disturb me all the time that I’m the only one in the group who takes the given work serious. I liked reading lessons and homeworks – also I liked the test – because they’ve been rather individual and independent. Later I recognized that it also can make fun and right now. I believe that cooperation is always needed. I do not really think that it’s possible to study by our own. Psychologically people need friends. Also it might be a kind of aim to be under people, to learn cooperating with people for kindergartens and schools when we get out into the life of workers we could give the expected niveau of work. \n" +
            "To my mind only literature is that subject that can be tough electronically With a webcam and a software like Skype is enough. But in maths, biology and any other classes children need the teacher to be attend. They need someone who walks along the tables and checks and corrects their daily work. If it happens as the author on that homepage explained, the student-student (I might risk to say also friendship) relationship and the student-teacher relationship will be slowly disappearing. In this case people ain’t feel love for others, it’s going to be harder to get a partner. I also can imagine that people are going to look for their matches on webpages, they’ll get engaged, married – but they’re never really going to love each but just their kid.\n" +
            "And a child, with no family that can show the needed amount of love, can also become dangerous to other people. \n" +
            "The electronic learning already started – as I recognized it in Norway as I’ve been studying there. In my class we’ve been 7, but I’ve been attend always alone, because my classmate were doing electronical job. I also got many tasks that I should record my essay and handle it in the format of “mp3” in. To my mind it’s a good way at languages to correct the accent.\n" +
            "I have plenty of plans with my children and their children and it doesn’t really contain internet. But like the article they’re gonna get in the middle and learn on a well required niveau. \n" +
            "It’s not a piece of cake to learn by our own. There is not going to be any motivation (heard from a classmate for example) and it parents don’t care, their child is going to fail at school and later at life. \n" +
            "But the most important thing at studying-home is the lack of the realizing about the beautyness of the world. No matter what people do in their free time but it they don’t have friends, they do not really organize trips in the nature – they’ll forget about it and slowly the interest for each and the Blue Planet will disappear.\n","One of the main objectives of education is to prepare children for work . In order to help a country grow economically , schools are encouraging students to study science , economics , computer skills , business and maths . Creative subjects like art and music are considered less important . However , I believe that they should continue to be taught in schools.\n" +
            "Music courses often include several different strands . At my school , the music course includes performance , music theory and composition . Each of these areas teaches a child different skills . Performing teaches children confidence . Music theory teaches analytical and mathematical skills . Composition allows students to be creative . Although it is true that many students who are interested in music take classes outside school , many young people do not have this opportunity because their parents aren’t musical . That’s why we need to continue to provide music lessons at schools.\n" +
            "Another creative subject under scrutiny is art . But art is everywhere in our society . It is in the clothes we wear and in the design of the products we buy . School art students go on to become illustrators, designers and architects . Also , creative people are often successful in other fields such as teaching and business . We need to encourage young people to think creatively and school art lessons are important in this way.\n" +
            "To conclude , I think it is very important that schools continue to teach creative subjects such as art and music as well as those subjects that are considered more important for the country’s economy . Not all young people get the opportunity to explore their creative sides out of school , and confident , creative people are equally important to a country’s economy as economists and scientists .\n","Hi Louisa , \n" +
            "Thanks for your email . I’m glad you can join us for the weekend away . There are indeed still free places , so your sister can come if she wants . I think the theme park has some rides for children , but my friends and I are definitely going to spend the day on the big rides , so your sister might have to spend time alone with Maddy , and so she might feel a bit left out . There is a twin room free that your sister and Maddy can have . Your sister will have to be careful with Maddy because there’s a lake on the site and we wouldn’t want Maddy to fall in .  It gets quite muddy there and it will be getting dark when we arrive , so your sister had better not let Maddy run off . As you know , I’ve booked a night out at a curry restaurant and a bar in the evening , and I don’t think that’ll be suitable for Maddy . She’ll probably need to be tucked up in bed by that time . Your sister will have to stay at the cottage alone to look after her , unless you’re happy to stay in and keep her company . So , in short , your sister is welcome to come , but it might be a bit boring for her at times . \n","While you are in Westbury , you must visit the White Horse Country Park . The park is situated on the top of a hill overlooking the town , and has magnificent views across the countryside . The famous white horse , a chalk symbol which can be seen from many miles away , lies on the side of the hillside . The park is also the site of an Iron Age fort , and everyone , from young children to adults , can enjoy climbing on the banks and can even roll down some of the gentle slopes . If you have a kite , bring it along because there is often a strong breeze on the hill . There are a number of paths around the park where you can take in the view . These may not be suitable for people with pushchairs , wheel chair users and people who are unsure of their footing . After your exertions , you can enjoy an ice cream from the ice cream van which is always present . The easiest way to get there is by car . Just leave the town along the Bratton road and take the road on the right next to the pottery shop . The road is well signposted . If you don’t have a car , you can get a taxi . A trip will cost about £5 from the town centre . Otherwise it’s a steep , 45-minute walk . Entrance to the park is free of charge .","Dear Sir / Madam , \n" +
            "I read your advertisement in Students International and I would be very interested in volunteering in the sporting event you are organising . I am a French student and I have been studying English for eight years . I have taken part in several language exchange visits to the United Kingdom , so I can communicate confidently and quite fluently in English in social situations . I also speak a little Italian and German . \n" +
            "I believe that I have good personal qualities which make me an effective volunteer for your event . I am outgoing and enjoy meeting people from different cultures . I have played in the college volleyball and football teams for over four years , so I am used to working with other people and encouraging them in our shared endeavours . I also have work experience in working on the front line with customers . I work at weekends in our local supermarket , which requires me to deal with customers with a pleasant attitude and liaise with other staff . I have also worked as a receptionist in a hotel in the south of France as a summer job . Here , I had to welcome guests and deal with any problems which arose . I can send you references from these employers if you need them.\n" +
            "Thank you for your interest in my application . I look forward to hearing from you .\n","Thank you for giving me the opportunity to give feedback about my experiences at Brightwell College. Firstly , I’d like to talk about the teachers , who were excellent . They prepared us very well for examinations , and it’s down to them that so many of us obtained good grades. We always had the opportunity to discuss our ideas in class and the teachers never dismissed our ideas , no matter how strange they were ! Having said that , the homework workload was very high. The teachers were very strict about handing it in and rarely gave us extensions . Although I realise that homework is important, I do feel they could have been given less homework and been less strict about deadlines , as this often prevented us from getting involved in sports and clubs and having evening jobs. Furthermore , although the teaching was excellent , the facilities were not. The text books we used were very outdated , the library did not have enough desks , and there were not enough copies of important books . There were also not enough computers for the whole class to use at the same time . Socially , there were a lot of sports and music clubs to join , but very few others . I would have been interested in taking extracurricular classes in drama , woodwork and cookery but these classes were not available , which was disappointing . Secondly , the school organised very few outings except for a few geography and biology field trips , and I would have liked the opportunity to go on activity holidays with my classmates , such as ski trips or adventure sport weekends","I would like to respond to your request for money-saving tips for students . As I see it , there are two main things that a student needs to think about : how increase your income , and how to reduce your outgoings . \n" +
            "Getting a part time job is really worthwhile when you’re young . Not only does it bring money in , but it will impress future employers . Find a job which fits into your schedule . Many shops offer Saturday jobs , while you can get jobs at bars and restaurants in the evening . There are also lots of holiday jobs available in hotels , holiday camps or on farms . \n" +
            "Secondly , you need to decrease what you spent . If you cook for yourself , buy value products and avoid ready-made meals . Share cheap recipes with friends . You will save money on food and energy bills if you buy food and cook it in bulk , so get together with friends and share the cooking . When shopping for clothes and utensils , buy second hand from markets or from online auction sites . Just don’t get carried away ! It’s easy to spend a lot when things are cheap ! \n" +
            "Of course , you don’t want to stop spending altogether , or you will never have any fun ! So it’s important to prioritise . Decide what’s important to you , whether it’s sports , travel , good food , nights out or nice clothes , and put enough money aside for that . Then you can scrimp and save on the things that you consider less important .\n","Dear Sir/Madam, \n" +
            "I attended a twenty-four hour per week course for two weeks in July at the Heaton School of English. I am writing to you because I understand that this school is accredited by your organisation. \n" +
            "The standards of the school fell short of those expected from an accredited school and those which were advertised by the school. \n" +
            "The school promised qualified and experienced native English teachers. In reality several of these teachers had not taught before and lacked any knowledge of pedagogy. The classes were made up of a random selection of students: different ages, abilities and reasons for studying English. \n" +
            "I was promised in advance a course to prepare me for examinations but this was unavailable, so how the school can boast of a high exam pass rate is inexplicable. The school also undertook to provide modern functioning computers; in reality the computers were both dated and often non-operational.\n" +
            "In view of this completely unsatisfactory course, in breach of both your stipulated standards and the advertising of the Heaton School, I am asking for a full refund of the course fee. I would like your advice and assistance in this matter. \n" +
            "Yours faithfully, \n" +
            "Bridget Reninson.\n","Grenberg Decongested? \n" +
            "Last week in a rainy November morning I set off from my home to drive into town, along about a quarter of the ring road in the direction of the town hall. In all, the journey is about ten kilometres; it took an hour and a half. \n" +
            "From Monday however to make the same journey I will have to buy a EUR 10 sticker for my windscreen window. Entering the ring round and the centre of the town without a sticker will cost EUR 100 in an on-the-spot fine. \n" +
            "Congestion charging has been proposed for years, but when Arnie Fischer was re-elected mayor for a third term in April, he gave an explicit promise to promote the charge. As he pointed out yesterday in the Grenberg Times the charge ‘will lessen congestion and raise money for public transport.’ Fischer has allocated an extra EUR 1 million to upgrade the bus and tram network. \n" +
            "The campaign Grenberg Free Roads has mounted an on-going battle against road charging. Group spokesperson, Edgar Grice, told me yesterday, ‘We are going to challenge this law in the courts. Nobody is going to make me pay for using the public roads.’ Perhaps Mr Grice will be among the first people to pay the EUR 100 fine. \n" +
            "An opinion poll last week showed an overwhelming backing of 86% in favour of the charge.\n","Two very different plays are currently being shown at Grenberg’s Playhouse this week. \n" +
            "For those who enjoy romantic comedy, you shouldn’t miss Ben Gold’s “It Happened to Me” featuring young Sarah Jenner as the incurable romantic Jude Smith. Producer, Hermann Shils has made several innovations on the original play, nearly all of which have added to the humour and flow of the performance. Also don’t miss an excellent performance by the slick and well-casted Jeremy Fletcher as the hapless Alfie. \n" +
            "Tuesday and Friday are given over to heavy-going “Death in the Morning” by local playwright, Miriam Pink. The protagonist, Elsa, is played by the talented Gertrude Horn who has made this tragic role her own. Some commentators doubted whether Pink could produce this performance of her own play, but she seems to have effortlessly made the transition from playwright to producer. \n" +
            "Seats are selling fast for “It Happened to Me” which has the edge on popularity, though, while singing the praise of both plays, I would say “Death in the Morning” is the better drama. But why not treat yourself to two theatre outings this week?\n","‘Stereotypes help us understand the world.’ \n" +
            "Stereotypes, as forms of generalisation and the abstraction of the key features of things, are necessary for understanding the world around us; however the blind use of stereotypes can lead to misunderstanding. \n" +
            "If, for example, you imagine every type of chair in the world you have an array of thousands. Yet to all these entities we apply the stereotype – or label – chair. If somebody asks us what a chair is we don’t start by listing everything that is a chair. Instead, we utter some key features of a chair which in our view characterise all chairs; e.g. a surface for sitting above the ground. \n" +
            "What applies to chairs of course applies to everything else in the world that we think about: a family, a government, bad behaviour and so on. What then are the dangers in this mode of abstraction? I will mention two. \n" +
            "First, and perhaps most important, is when we assemble stereotypes according to prejudicial thinking. In the past, and among some people today, concepts are constructed according to false stereotypes; e.g. labelling certain work as women’s or men’s work. \n" +
            "Second, is simply when we define our stereotypes too narrowly or widely to make them useful. An example of the former is defining a chair as having four legs. Why can’t a chair have three or four? An example of the latter would be defining a chair as something that can be sat on. Well a tree trunk can be sat upon. \n" +
            "In conclusion, stereotypes are useful but should not be used lazily.\n");

    private List<String> c2= Arrays.asList();


    private List<String> teste= Arrays.asList("if if if if if if.");

}

package CodeAbbey;

import java.util.Scanner;

public class CodeAbbey_ImageCutting {
    public static void main(String[] args) {

//        https://www.codeabbey.com/index/task_view/image-cutting
//        TV screens have a fixed width to height ratio. This is usually 16:9. Images that are shown in the television have to have this exact aspect ratio.
//
//        If you want to show your image in a device which accepts images with a fixed aspect ratio, you must first cut it to the requested ratio.
//        But you do not want to lose too much of your image.
//        What is the biggest area of the image you can cut for a given aspect ratio, in pixel squares if your image has a certain width and height in pixels?
//
//        Input data: First line will contain number of images to be cut.
//        Other lines will contain width and height of the image WxH and the aspect ratio of the display W:H separated by space.
//        Answer: You should output the area of the fitting part of the image.
//
//        Example:
//
//        input data:
//        3
//        4702x3938 1:1
//        3739x5070 16:9
//        4572x4166 2:1
//
//        answer:
//        15507844 7817616 10451592


        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            String[] parti = s.split(" ");
            String[] risoluzioneArray = parti[0].split("x");
            String[] ratioArray = parti[1].split(":");

            // debug
            System.out.println(">>" + parti[0] + "<<");
            System.out.println(">>" + parti[1] + "<<");

            int w = Integer.parseInt(risoluzioneArray[0]);
            int h = Integer.parseInt(risoluzioneArray[1]);
            int ratioW = Integer.parseInt(ratioArray[0]);
            int ratioH = Integer.parseInt(ratioArray[1]);

            int wTagliato, hTagliato;

            if (w * ratioH <= h * ratioW) { // test con larghezza
                wTagliato = w;
                hTagliato = (w * ratioH) / ratioW;
            } else { // teste con altezza
                hTagliato = h;
                wTagliato = (h * ratioW) / ratioH;
            }

            int area = wTagliato * hTagliato;
            System.out.println(area + " ");
        }
    }
}

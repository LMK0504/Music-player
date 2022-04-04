package Project;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.*;
import org.jaudiotagger.tag.*;
import jaco.mp3.player.MP3Player;

public class MP3_player {

   public static void main(String[] args) {
      ArrayList<String> music = new ArrayList<>();
      Scanner scan = new Scanner(System.in);
      StartPlayer(music);
      int exit = 1;
      while (exit == 1) {
         int i = 0;
         MainMenu();
         try {
            Scanner scan2 = new Scanner(System.in);
            i = scan2.nextInt();
         } catch (InputMismatchException e) {
            for (int k = 0; k < 25; k++)
               System.out.println();
            System.out.println("������ �޴��� �Է����ּ���");
         }
         switch (i) {
         case 1:
            for (int k = 0; k < 25; k++)
               System.out.println();
            player player = new player(music);
            runSubMenu(scan, music, player);
            break;
         case 2:
            for (int k = 0; k < 25; k++)
               System.out.println();
            runSubMenu2(scan, music);
            break;
         case 3:
            exit = 0;
            return;
         default:
            for (int k = 0; k < 25; k++)
               System.out.println();
            System.out.println("�ٽ� �Է����ּ���");
            break;
         }
      }
      System.out.println("���α׷��� �����մϴ�.");
   }

   static void StartPlayer(ArrayList<String> music) {
      File dir = new File("C:\\Users\\moble\\Desktop\\�� ����");
      FilenameFilter filter = new FilenameFilter() {
         public boolean accept(File f, String name) {
            return name.endsWith(".mp3");
         }
      };

      File files[] = dir.listFiles(filter);
      for (int i = 0; i < files.length; i++) {
         music.add(files[i].getPath());
      }
   }

   static void MainMenu() {
      System.out.println("====��  ��====");
      System.out.println("1. ���     ");
      System.out.println("2. ���ϰ���  ");
      System.out.println("3. ����     ");
      System.out.println("=============");

   }

   static void SubMenu() {
      System.out.println("====��  ��====");
      System.out.println("1. ��ü���   ");
      System.out.println("2. �������   ");
      System.out.println("3. �������   ");
      System.out.println("4. �ڷ� ����  ");
      System.out.println("�߸��Է½� ���� �޴��� �̵�");
      System.out.println("=============");
   }

   static void SubMenu2() {
      System.out.println("==���� �߰� ����==");
      System.out.println("1. �����߰�");
      System.out.println("2. ���ǻ���");
      System.out.println("3. ����Ʈ ����");
      System.out.println("4. �ڷ� ����");
      System.out.println("�߸��Է½� ���� �޴��� �̵�");
      System.out.println("===============");
   }

   static void runSubMenu(Scanner scan, ArrayList<String> music, player player) {
      do {
         int j = 0;
         SubMenu();
         try {
            Scanner scan2 = new Scanner(System.in);
            j = scan2.nextInt();
         } catch (InputMismatchException e) {
            for (int k = 0; k < 25; k++)
               System.out.println();
            System.out.println("������ �޴��� �Է����ּ���");
         }
         switch (j) {
         case 1:
            for (int k = 0; k < 25; k++)
               System.out.println();
            player.playmusic();
            break;
         case 2:
            for (int k = 0; k < 25; k++)
               System.out.println();
            player.RandomPlay();
            break;
         case 3:
            for (int k = 0; k < 25; k++)
               System.out.println();
            player.pickPlay();
            break;
         default:
            for (int k = 0; k < 25; k++)
               System.out.println();
            return;
         }
      } while (true);
   }

   static void runSubMenu2(Scanner scan, ArrayList<String> music) {
      do {
         SubMenu2();
         int j = 0;
         try {
            Scanner scan2 = new Scanner(System.in);
            j = scan2.nextInt();
         } catch (InputMismatchException e) {
            for (int k = 0; k < 25; k++)
               System.out.println();
            System.out.println("������ �޴��� �Է����ּ���");
         }
         switch (j) {
         case 1:
            music.add(new Music().Path);
            for (int k = 0; k < 25; k++)
               System.out.println();
            System.out.println("����Ʈ�� �߰��Ǿ����ϴ�.");
            break;
         case 2:
            for (int k = 0; k < 25; k++)
               System.out.println();
            if (music.size() == 0) {
               System.out.println("����Ʈ�� �����ϴ�.");
               continue;
            }
            for (int i1 = 0; i1 < music.size(); i1++) {

               System.out.println((i1 + 1) + ". " + music.get(i1));
            }
            System.out.print("����� �����Ͻðڽ��ϱ�? : ");
            String num1 = scan.next();
            int num = 0;
            boolean ft = num1.chars().allMatch(Character::isDigit);
            if (ft == false) {
               for (int k = 0; k < 25; k++)
                  System.out.println();
               System.out.println("���ڿ� �Է� �Ұ�");
               break;
            } else {
               num = Integer.parseInt(num1);
            }

            if (num > music.size() || num < 0) {
               for (int k = 0; k < 25; k++)
                  System.out.println();
               System.out.println("�����ϴ�! �ٽ��Է��Ͽ� �ּ���.");
               break;
            }
            music.remove(num - 1);
            for (int k = 0; k < 25; k++)
               System.out.println();
            System.out.println("����Ʈ�� �����Ǿ����ϴ�.");
            break;
         case 3:
            for (int k = 0; k < 25; k++)
               System.out.println();
            if (music.size() == 0) {
               System.out.println("����Ʈ�� �����ϴ�.");
               break;
            }
            for (int i1 = 0; i1 < music.size(); i1++) {
               System.out.println((i1 + 1) + ". " + music.get(i1));
            }
            break;
         default:
            for (int k = 0; k < 25; ++k)
               System.out.println();
            System.out.println("�޴� ����");
            return;
         }
      } while (true);
   }
}

class player {
   ArrayList<File> file = new ArrayList<>();
   ArrayList<File> random_file = new ArrayList<>();
   ArrayList<String> path;
   ArrayList<MP3Player> mp3 = new ArrayList<>();
   ArrayList<MP3Player> Random_mp3 = new ArrayList<>();
   Scanner scan = new Scanner(System.in);
   static int i;
   static int back;

   public player(ArrayList<String> music) {
      this.path = music;
      for (i = 0; i < path.size(); i++) {
         File files = new File(path.get(i));
         file.add(files);
         mp3.add(new MP3Player(files));
      }
   }

   public void playmusic() {
      if (file.size() == 0) {
         System.out.println("�뷡�� �����ϴ�.");
      }
      i = 0;
      while (i < mp3.size()) {
         Task t1 = new Task(mp3, i);
         t1.setDaemon(true);
         t1.start();
         mp3.get(i).play();
         go(file.get(i));
         allPlaymenu();
         while (mp3.get(i).isStopped() == false) {
            if (mp3.get(i).isStopped()) {
               break;
            }
         }
         try {
            Thread.sleep(500);
         } catch (InterruptedException e) {
            for (int k = 0; k < 25; k++)
               System.out.println();
            e.printStackTrace();
         }
         if (back == -1 && i == 0) {
            i = mp3.size() - 1;
            continue;
         } else if (back == -1 && i > 0) {
            i = i - 1;
            continue;
         }
         if (back == 0 && i == mp3.size() - 1) {
            i = 0;
            continue;
         } else if (back == 0 && i < mp3.size() - 1) {
            i++;
         }
         if (back == 2) {
            player.i = mp3.size() - 1;
            i++;
         }
      }
   }

   public void RandomPlay() {
      if (file.size() == 0) {
         System.out.println("�뷡�� �����ϴ�.");
      }
      int[] random = new int[mp3.size()];
      for (int i = 0; i < random.length; i++) {
         random[i] = i;
      }
      for (int j = 0; j < random.length; j++) {
         int i = (int) Math.random() * random.length;
         int memory = random[j];
         random[j] = random[i];
         random[i] = memory;
      }
      for (int k = 0; k < random.length; k++) {
         Random_mp3.add(mp3.get(random[k]));
         random_file.add(file.get(random[k]));
      }
      i = 0;
      while (i < Random_mp3.size()) {
         Task t1 = new Task(Random_mp3, i);
         t1.setDaemon(true);
         t1.start();
         Random_mp3.get(i).play();
         go(random_file.get(i));
         allPlaymenu();
         while (Random_mp3.get(i).isStopped() == false) {
            if (Random_mp3.get(i).isStopped()) {
               break;
            }
         }
         try {
            Thread.sleep(500);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
         if (back == -1 && i == 0) {
            i = mp3.size() - 1;
            continue;
         } else if (back == -1 && i > 0) {
            i = i - 1;
            continue;
         }
         if (back == 0 && i == mp3.size() - 1) {
            i = 0;
            continue;
         } else if (back == 0 && i < mp3.size() - 1) {
            i++;
         }
         if (back == 2) {
            player.i = mp3.size() - 1;
            i++;
         }
      }
   }

   public void pickPlay() {
      if (file.size() == 0) {
         System.out.println("�뷡�� �����ϴ�.");
         return;
      }
      for (int i1 = 0; i1 < file.size(); i1++) {
         System.out.println((i1 + 1) + ". " + path.get(i1));
      }
      String z1 = scan.next();
      int z = 0;
      boolean tf = z1.chars().allMatch(Character::isDigit);
      if (tf == false) {
         for (int k = 0; k < 25; k++)
            System.out.println();
         System.out.println("���ڿ� �Է� �Ұ�");
         return;
      } else {
         z = Integer.parseInt(z1);
      }
      for (int k = 0; k < 25; ++k)
         System.out.println();
      int back = 0;
      if (z > mp3.size() || z < 0) {
         for (int k = 0; k < 25; k++)
            System.out.println();
         System.out.println("�߸� �Է��ϼ̽��ϴ�. �� �ܰ�� ���ư��ϴ�.");
         return;
      }
      mp3.get(z - 1).play();
      go(file.get(z - 1));
      while (mp3.get(z - 1).isStopped() == false) {
         while (back == 0) {
            playmenu();
            int c = scan.nextInt();
            switch (c) {
            case 1:
               for (int k = 0; k < 25; ++k)
                  System.out.println();
               if (mp3.get(z - 1).isStopped() == true) {
                  mp3.get(z - 1).play();
               } else {
                  mp3.get(z - 1).stop();
               }
               break;
            case 2:
               for (int k = 0; k < 25; ++k)
                  System.out.println();
               if (mp3.get(z - 1).isPaused() == true) {
                  mp3.get(z - 1).play();
               } else
                  mp3.get(z - 1).pause();
               break;
            case 3:
               for (int k = 0; k < 25; ++k)
                  System.out.println();
               mp3.get(z - 1).stop();
               return;
            default:
               for (int k = 0; k < 25; ++k)
                  System.out.println();
               System.out.println("�߸� �Է��ϼ̽��ϴ�. �� �ܰ�� ���ư��ϴ�.");
               mp3.get(z - 1).stop();
               return;
            }
         }
         if (mp3.get(z - 1).isStopped()) {
            break;
         }
      }
   }

   public void go(File file) {
      try {
         MP3File mp3 = (MP3File) AudioFileIO.read(file);
         mp3.getAudioHeader().getTrackLength();
         int min = (mp3.getAudioHeader().getTrackLength()) / 60;
         int sec = (mp3.getAudioHeader().getTrackLength()) % 60;
         Tag tag = mp3.getTag();
         String title = tag.getFirst(FieldKey.TITLE);
         String artist = tag.getFirst(FieldKey.ARTIST);
         String album = tag.getFirst(FieldKey.ALBUM);
         String year = tag.getFirst(FieldKey.YEAR);
         String genre = tag.getFirst(FieldKey.GENRE);
         System.out.println("�� �� : " + title);
         System.out.println("�� �� : " + artist);
         System.out.println("�� �� : " + album);
         System.out.println("�߸� �� : " + year);
         System.out.println("�� �� : " + genre);
         System.out.println("��� �ð� : " + min + "�� " + sec + "��");
      } catch (Exception ex) {
         ex.printStackTrace();
      }
   }

   public void allPlaymenu() {
      System.out.println("======���� â======");
      System.out.println("1.�� �Ͻ�����/����");
      System.out.println("2.������ ����");
      System.out.println("3.������ ����");
      System.out.println("4.�ڷ� ����");
      System.out.println("=================");
   }

   public void playmenu() {
      System.out.println("=======���� â=======");
      System.out.println("1. �� ����/����");
      System.out.println("2. �� �Ͻ�����/����");
      System.out.println("3. �ڷ� ����");
      System.out.println("====================");
   }
}

class Music {
   String Path;
   String Name;
   String Last_name;

   Music() {
      Frame f = new Frame("MP3");
      f.setSize(100, 100);
      f.setVisible(true);
      FileDialog fileOpen = new FileDialog(f, "���Ͽ���", FileDialog.LOAD);
      fileOpen.setVisible(true);
      Last_name = fileOpen.getFile().toString();
      this.Path = fileOpen.getDirectory().toString() + fileOpen.getFile().toString();
      fileOpen.getFile().toString();
      f.setVisible(false);
   }
}

class Task extends Thread {
   int i;
   ArrayList<MP3Player> mp3;
   Scanner scan = new Scanner(System.in);

   public Task(ArrayList<MP3Player> mp3, int i) {
      this.i = i;
      this.mp3 = mp3;
   }

   @Override
   public void run() {
      while (mp3.get(i).isStopped() == false) {
         int select=0;
         String select1 = scan.next();
         boolean ft=select1.chars().allMatch(Character::isDigit);
         if(ft==false) {
            for(int k=0;k<25;k++)
               System.out.println();
            System.out.println("���ڿ� �Է� �Ұ�");
            player.back = 2;
            player.i = mp3.size() - 1;
            mp3.get(i).stop();
            break;
         }else {
            select=Integer.parseInt(select1);
         }
         if (select == 1) {
            if (mp3.get(i).isPaused() == true) {
               for (int k = 0; k < 25; ++k)
                  System.out.println();
               System.out.println("������ �ٽ� ���� �մϴ�.");
               allPlaymenu();
               mp3.get(i).play();
            } else {
               for (int k = 0; k < 25; ++k)
                  System.out.println();
               System.out.println("�������� ������ ���� �մϴ�.");
               allPlaymenu();
               mp3.get(i).pause();
            }
         } else if (select == 2) {
            player.back = 0;
            mp3.get(i).stop();
            for (int k = 0; k < 25; ++k)
               System.out.println();
            System.out.println("�������� ���� �մϴ�.");
         } else if (select == 3) {
            mp3.get(i).stop();
            for (int k = 0; k < 25; ++k)
               System.out.println();
            System.out.println("�������� ���� �մϴ�.");
            player.back = -1;
         } else if (select == 4) {
            for (int k = 0; k < 25; ++k)
               System.out.println();
            System.out.println("�� �ܰ�� ���ư��ϴ�.");
            player.back = 2;
            player.i = mp3.size() - 1;
            mp3.get(i).stop();
         } else {for (int k = 0; k < 25; ++k)
            System.out.println();         
            System.out.println("�߸� �Է��ϼ̽��ϴ�. �� �ܰ�� ���ư��ϴ�.");
            player.back = 2;
            player.i = mp3.size() - 1;
            mp3.get(i).stop();
         }
      }
   }

   public void allPlaymenu() {
      System.out.println("======���� â======");
      System.out.println("1.�� �Ͻ�����/����");
      System.out.println("2.������ ����");
      System.out.println("3.������ ����");
      System.out.println("4.�ڷ� ����");
      System.out.println("=================");
   }
}
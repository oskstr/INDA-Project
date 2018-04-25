# INDA 17 - Project plan

**studenter:** @oskstr @kittyt

**programmeringsspråk:** Java

## Projektbeskrivning
inda16-example är ett storslaget exempelprojekt där användaren får interagera med ett grafiskt interface för att navigera sig runt i en exempelvärld. Projektet kommer att skrivas med hjälp av grafikbiblioteket **JavaFX**. 

I projektet kan användaren, med hjälp av piltangenterna flytta runt markören på skärmen och markera saker. När användaren trycker på mellanslag så blinkar markören väldigt vackert.

Projektet kommer att bestå av ungefär 7 klasser:

**bild på klassdiagram**

Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis vehicula eget tellus eu gravida. Praesent nec risus ac purus blandit pellentesque. Sed malesuada lacus a dolor lacinia vulputate. Morbi rhoncus consectetur dui, vitae accumsan urna ornare eu. Aliquam nisi lacus, interdum at auctor vitae, ultricies sit amet massa. Morbi ultrices nunc nec augue rutrum volutpat. In eget lectus urna. Fusce sagittis tincidunt quam et dapibus. Nulla consectetur dignissim tortor, eu ultrices orci tristique congue.

## How-to-run
Pga. projektets fantastiska [makefile](http://mrbook.org/blog/tutorials/make/) så körs projektet med det simpla kommandot
`make run`, detta både kompilerar projektet och kör det! (WHAAAT)

## Testningsstrategi

Vi kommer att testa våra klasser som inte direkt har att göra med grafiken med unittester, de grafikritande klasserna kommer vi att bara testa genom att köra projetet många gånger och försöka få saker att gå sönder.

import java.util.*;

class MatchingScore {
    class WebPage{
        int index;
        String url;
        double basicScore;
        ArrayList<String> linkWebs;
        double totalScore;
        public WebPage(int index, String url, double basicScore, ArrayList<String> linkWebs){
            this.index = index;
            this.url = url;
            this.basicScore = basicScore;
            this.linkWebs = linkWebs;
            this.totalScore = basicScore;
        }
    }

    public int solution(String word, String[] pages) {
        int answer = 0;
        ArrayList<WebPage> list = new ArrayList<WebPage>();

        word = word.toLowerCase();

        for(int i=0; i<pages.length; i++){
            pages[i] = pages[i].toLowerCase();
            String url = getUrl(pages[i]);
            double basicScore = getBasicScore(pages[i], word);
            ArrayList<String> linkWebs = getLinkWebs(pages[i]);
            list.add(new WebPage(i, url, basicScore, linkWebs));
        }

        for(int i=0; i<list.size(); i++){
            ArrayList<String> linkTemp = list.get(i).linkWebs;
            for(int j=0; j<list.size(); j++){
                if(i!=j){
                    if(linkTemp.contains(list.get(j).url)){
                        list.get(j).totalScore+= (double) (list.get(i).basicScore/(double)list.get(i).linkWebs.size());
                    }
                }
            }
        }

        Collections.sort(list, (o1,o2)->{
            if(o1.totalScore == o2.totalScore)
                return o1.index - o2.index;
            if(o1.totalScore < o2.totalScore) return 1;
            else return -1;
        });

        return list.get(0).index;
    }

    public String getUrl(String page){
        String temp = "<meta property=\"og:url\" content=\"";
        int start = page.indexOf(temp) + temp.length();
        int end = page.indexOf("\"",start);
        return page.substring(start,end);
    }

    public double getBasicScore(String page, String word){
        String temp = "<body>";
        int count = 0;
        int start = page.indexOf(temp) + temp.length();
        int end = page.indexOf("</body>", start);
        String body = page.substring(start,end);
        for(int i=0; i<body.length(); i++){
            char ch = body.charAt(i);
            if(ch<'a' || ch>'z'){
                body = body.replace(ch,' ');
            }
        }
        String[] bodyArray = body.split(" ");
        for(String bo : bodyArray){
            if(bo.equals(word)){
                count++;
            }
        }

        return count;
    }

    public ArrayList<String> getLinkWebs(String page){
        System.out.println("@@@@");
        ArrayList<String> links = new ArrayList<>();

        String temp = "<a href=\"";
        int start = 0;

        while(true){
            int tempStart = page.indexOf(temp, start) + temp.length();
            int tempEnd = page.indexOf("\"", tempStart);


            if(page.indexOf(temp,start) ==-1) break;

            start = tempEnd;

            links.add(page.substring(tempStart,tempEnd));
            //System.out.println(page.substring(tempStart,tempEnd)+"@");
        }

        return links;
    }

    public static void main(String[] args) {
        MatchingScore ms = new MatchingScore();

        String [] pages = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"};
        String word = "blind";

        ms.solution(word, pages);

    }
}

import java.util.*;
import java.util.regex.*;

class Solution {
    public int solution(String word, String[] pages) {
        Web.init(word);
        Web.add(pages);
        Web.calScore();
        return Web.getMaxScoreIdx();
    }
}

class Web {
    public static List<Web> pages;
    public static Map<String, Set<Web>> links;

    public static Pattern urlPattern = Pattern.compile("<meta property=\"og:url\" content=\"https://(\\S*)\"/>");
    public static Pattern linkPattern = Pattern.compile("<a href=\"https://(\\S*)\"");
    public static Pattern wordPattern;

    public static void init(String word) {
        pages = new ArrayList<>();
        links = new HashMap<>();
        wordPattern = Pattern.compile("\\b(?i)" + word + "\\b");
    }

    public static void add(String[] pages) {
        for (String page : pages) {
            new Web(page);
        }
    }

    public static void calScore() {
        for (Web page : pages) {
            for (Web link : links.getOrDefault(page.url, new HashSet<>())) {
                page.totalScore += (double) link.basicScore / link.linkCnt;
            }
        }
    }

    public static int getMaxScoreIdx() {
        int idx = 0;
        double max = -1;
        for (int i = 0, t = pages.size(); i < t; i++) {
            if (max >= pages.get(i).totalScore) continue;
            max = pages.get(i).totalScore;
            idx = i;
        }
        return idx;
    }

    public String url;
    public int basicScore;
    public int linkCnt;
    public double totalScore;

    public Web(String page) {
        pages.add(this);

        Matcher urlMatcher = urlPattern.matcher(page);
        if (urlMatcher.find()) url = urlMatcher.group(1);

        Matcher wordMatcher = wordPattern.matcher(page.replaceAll("[0-9]", " "));
        while (wordMatcher.find()) basicScore++;
        totalScore = basicScore;

        Matcher linkMatcher = linkPattern.matcher(page);
        while (linkMatcher.find()) {
            linkCnt++;
            links.computeIfAbsent(linkMatcher.group(1), k -> new HashSet<>()).add(this);
        }
    }
}
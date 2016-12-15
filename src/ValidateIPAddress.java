/**
 * Created by Nikhil on 12/15/16.
 */

/**
 * In this problem, your job to write a function to check whether a input string is a valid IPv4 address
 * or IPv6 address or neither.
 */
public class ValidateIPAddress {

    public String validIPAddress(String IP) {
        if (isIPV4(IP)) {
            return "IPv4";
        } else if (isIPV6(IP)) {
            return "IPv6";
        }
        return "Neither";
    }

    private boolean isIPV6(String IP) {
        IP = IP.toLowerCase();
        if (IP.contains(":")) {
            int count = 0;
            for (int i = 0; i < IP.length(); i++) {
                char c = IP.charAt(i);
                if (c == ':') {
                    count++;
                } else if (c >= 'a' && c <= 'f') {
                    continue;
                } else if (c >= '0' && c <= '9') {
                    continue;
                } else {
                    return false;
                }

                if ((i > 0 && IP.charAt(i) == ':' && IP.charAt(i - 1) == ':') || count > 7) {
                    return false;
                }

            }

            if (count < 7) {
                return false;
            }
            String[] IPArr = IP.split("\\:");
            for (int i = 0; i < IPArr.length; i++) {
                String str = IPArr[i];
                if (str.length() > 4 || str.equals("")) {
                    return false;
                }
            }
            return true;


        }

        return false;

    }

    private boolean isIPV4(String IP) {
        if (IP.contains(".")) {
            int count = 0;
            IP = IP.toLowerCase();
            for (int i = 0; i < IP.length(); i++) {
                char c = IP.charAt(i);
                if (c == '.') {
                    count++;
                } else if (c >= '0' && c <= '9') {
                    continue;
                } else {
                    return false;
                }
                if (count > 3 || (i > 0 && IP.charAt(i) == '.' && IP.charAt(i - 1) == '.')) {
                    return false;
                }
            }
            if (count < 3) {
                return false;
            }
            String[] arr = IP.split("\\.");
            for (int i = 0; i < arr.length; i++) {
                if(arr[i].length()>3 ||(arr[i].length()>1 &&arr[i].charAt(0)=='0')) return false;
                int ipParts = Integer.valueOf(arr[i]);
                if (ipParts < 0 || ipParts > 255) {
                    return false;
                }

            }
            return true;
        }
        return false;


    }
}

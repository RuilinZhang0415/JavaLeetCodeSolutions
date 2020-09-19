package main;

public class CompareVersionNumbers {
    private static class VersionNumber implements Comparable<VersionNumber> {
        private int version[], size;

        public VersionNumber(String versionStr) {
            String[] temp = versionStr.split("\\.");
            size = temp.length;
            version = new int[size];
            for (int i = 0; i < size; i++) version[i] = Integer.parseInt(temp[i]);
            while (size > 0 && version[size - 1] == 0) size--;
        }


        @Override
        public int compareTo(VersionNumber in) {
            int idx = 0;
            while (idx < this.size && idx < in.size) {
                if (this.version[idx] < in.version[idx]) return -1;
                else if (this.version[idx] > in.version[idx]) return 1;
                idx++;
            }

            if (this.size < in.size) return -1;
            else if (this.size > in.size) return 1;
            else return 0;
        }
    }

    public int compareVersion(String version1, String version2) {
        return new VersionNumber(version1).compareTo(new VersionNumber(version2));
    }

    public static void main(String[] args) {
        VersionNumber v1 = new VersionNumber("1.01.3");
        VersionNumber v2 = new VersionNumber("1.1.3.2");

        System.out.println(v1.compareTo(v2));
    }
}

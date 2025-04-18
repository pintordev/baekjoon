import java.util.*;

class Solution {
    public static Set<Frame> frames;

    public int[][] solution(int n, int[][] build_frame) {
        frames = new HashSet<>();

        for (int[] bf : build_frame) {
            Frame frame = new Frame(bf[0], bf[1], bf[2]);
            if (bf[3] == 1 && canBuild(frame)) frames.add(frame);
            else if (bf[3] == 0 && canRemove(frame)) frames.remove(frame);
        }

        return frames.stream()
                .sorted()
                .map(b -> new int[]{b.x, b.y, b.type})
                .toArray(int[][]::new);
    }

    public boolean canBuild(Frame frame) {
        if (frame.type == 0) {
            return frame.y == 0
                    || frames.contains(new Frame(frame.x, frame.y - 1, 0))
                    || frames.contains(new Frame(frame.x - 1, frame.y, 1))
                    || frames.contains(new Frame(frame.x, frame.y, 1));
        } else {
            return frames.contains(new Frame(frame.x, frame.y - 1, 0))
                    || frames.contains(new Frame(frame.x + 1, frame.y - 1, 0))
                    || (frames.contains(new Frame(frame.x - 1, frame.y, 1)) && frames.contains(new Frame(frame.x + 1, frame.y, 1)));
        }
    }

    public boolean canRemove(Frame frame) {
        frames.remove(frame);

        Set<Frame> surroundings = new HashSet<>();
        if (frame.type == 0) {
            surroundings.add(new Frame(frame.x, frame.y + 1, 0));
            surroundings.add(new Frame(frame.x - 1, frame.y + 1, 1));
            surroundings.add(new Frame(frame.x, frame.y + 1, 1));
        } else {
            surroundings.add(new Frame(frame.x, frame.y, 0));
            surroundings.add(new Frame(frame.x + 1, frame.y, 0));
            surroundings.add(new Frame(frame.x - 1, frame.y, 1));
            surroundings.add(new Frame(frame.x + 1, frame.y, 1));
        }

        for (Frame f : surroundings) {
            if (frames.contains(f) && !canBuild(f)) {
                frames.add(frame);
                return false;
            }
        }
        return true;
    }
}

class Frame implements Comparable<Frame> {
    int x;
    int y;
    int type;

    public Frame(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Frame)) return false;
        Frame f = (Frame) o;
        return this.x == f.x && this.y == f.y && this.type == f.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, type);
    }

    @Override
    public int compareTo(Frame o) {
        if (this.x == o.x && this.y == o.y) return this.type - o.type;
        if (this.x == o.x) return this.y - o.y;
        return this.x - o.x;
    }
}
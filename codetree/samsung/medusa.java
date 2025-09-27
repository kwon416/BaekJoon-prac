package codetree.samsung;

import java.util.*;

// 24년 하반기 오후 1번
public class medusa {

    public static int N, M;

    public static class Point {
        public int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public static boolean equals(Point p1, Point p2) {
            return p1.x == p2.x && p1.y == p2.y;
        }
    }
    static Point medusaPoint;
    static Point parkPoint;

    static int[][] map;
    // 메두사와 전사 1번째 이동 -  상, 하, 좌, 우
    static int[][] Dxy = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    // 전사 2번째 이동 - 좌, 우, 상, 하
    static int[][] Dxy2 = { {0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    // 시야 3갈래 위, 아래, 좌, 우
    static final int[][][] VISION = {
            { {-1, -1}, {-1, 0}, {-1, 1} }, // 상
            { {1, -1}, {1, 0}, {1, 1} }, // 하
            { {-1, -1}, {0, -1}, {1, -1} }, // 좌
            { { -1, 1}, {0, 1}, {1, 1} }  // 우
    };

    static int[][] dist; // 공원에서 출발하는 최단거리

    static void moveMedusa() {
        // 메두사가 최단거리로 움직인다.
        int x = medusaPoint.x;
        int y = medusaPoint.y;
        for (int[] dxy : Dxy) {
            int nx = x + dxy[0];
            int ny = y + dxy[1];
            if (isRange(nx, ny) && dist[nx][ny] != -1 && dist[nx][ny] < dist[x][y]) {
                medusaPoint.x = nx;
                medusaPoint.y = ny;
                return;
            }
        }
    }

    static int[][] bfsDistFromPark(int[][] map, Point park) {
        int N = map.length;
        int[][] dist = new int[N][N];
        for (int[] row : dist) Arrays.fill(row, -1);
        Queue<Point> q = new LinkedList<>();
        q.add(park);
        dist[park.x][park.y] = 0;

        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int[] dxy : Dxy) {
                int nx = p.x + dxy[0];
                int ny = p.y + dxy[1];
                if (!isRange(nx, ny) || map[nx][ny] == 1 || dist[nx][ny] != -1) continue;
                dist[nx][ny] = dist[p.x][p.y] + 1;
                q.add(new Point(nx, ny));
            }
        }
        return dist;
    }

    static boolean isRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    // 전사 관리
    static class WarriorMap {
        public final int N;
        public final ArrayList<Point> warriors;
        public final HashSet<Integer>[][] cell;

        WarriorMap(int N, List<Point> warriors) {
            this.N = N;
            this.warriors = new ArrayList<>(warriors);
            this.cell = new HashSet[N][N];
            for (int i = 0; i< N; i++)
                for (int j = 0; j< N; j++)
                    cell[i][j] = new HashSet<>();
            for (int i = 0; i < N; i++) {
                Point p = warriors.get(i);
                cell[p.x][p.y].add(i);
            }
        }

        boolean isWarriorAt(int x, int y) {
            return !cell[x][y].isEmpty();
        }

        int[] moveAll(int[][] bestVision) {
            int mx = medusaPoint.x;
            int my = medusaPoint.y;
            // 이동 전 같은 칸 전사 제거
            removeSameCell(mx, my);

            int step = 0;
            for (int i = 0; i < warriors.size(); i++) {
                Point p = warriors.get(i);
                if (bestVision[p.x][p.y] == 0) {
                    step += moveOnce(i, mx, my, bestVision, Dxy);
                    step += moveOnce(i, mx, my, bestVision, Dxy2);
                }
            }
            // 이동 후 같은 칸 전사 제거
            int attackers = removeSameCell(mx, my);
            return new int[]{step, attackers};
        }

        int moveOnce (int i, int mx, int my, int[][] vision, int[][] pri) {
            Point p = warriors.get(i);
            int x = p.x;
            int y = p.y;
            int d0 = manhattan(x, y, mx, my);

            for (int[] d : pri) {
                int nx = x + d[0];
                int ny = y + d[1];
                if (!isRange(nx, ny)) continue;
                if (vision[nx][ny] == 1) continue;
                if (manhattan(nx, ny, mx, my) < d0) {
                    cell[x][y].remove(i);
                    p.x = nx;
                    p.y = ny;
                    cell[nx][ny].add(i);
                    return 1;
                }
            }
            return 0;
        }


        int removeSameCell(int mx, int my) {
            int removed = 0;
            int i = 0;
            while (i < warriors.size()) {
                Point w = warriors.get(i);
                if (w.x == mx && w.y == my) {
                    removeWarrior(i);
                    removed++;
                } else {
                    i++;
                }
            }
            return removed;
        }

        void removeWarrior(int idx) {
            int last = warriors.size() - 1;
            Point cur = warriors.get(idx);
            cell[cur.x][cur.y].remove(idx);

            if (idx != last) {
                Point lastW = warriors.get(last);
                // 스왑
                warriors.set(idx, lastW);
                // 셀에서 인덱스 갱신
                cell[lastW.x][lastW.y].remove(last);
                cell[lastW.x][lastW.y].add(idx);
            }
            warriors.remove(last);
        }


    }

    static int manhattan(int ax, int ay, int bx, int by) {
        return Math.abs(ax - bx) + Math.abs(ay - by);
    }

    static class VisionResult {
        int [][] map;
        int seen;
        VisionResult(int[][] map, int seen) {
            this.map = map;
            this.seen = seen;
        }

    }

    static VisionResult buildVision(WarriorMap wm, Point medusaPoint, int[][] dxys) {
        int mx = medusaPoint.x;
        int my = medusaPoint.y;
        int[][] vis = new int[N][N];
        int seen = 0;

        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> occ = new LinkedList<>();
        q.add(new int[]{mx, my});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for (int i = 0; i < 3; i++) {
                int nx = x + dxys[i][0];
                int ny = y + dxys[i][1];
                if (!isRange(nx, ny) && vis[nx][ny] == 1) continue;
                if (wm.isWarriorAt(nx, ny)) {
                    int type;
                    if (nx == mx || ny == my) type = 1;
                    else {
                        boolean sameSign = (nx - mx) * dxys[0][0] > 0 && (ny - my) * dxys[0][1] > 0;
                        type = sameSign ? 0 : 2;
                    }
                    occ.add(new int[]{nx, ny, type});
                }
                vis[nx][ny] = 1;
                q.add(new int[]{nx, ny});
            }
        }

        // 가림 처리
        while (!occ.isEmpty()) {
            int[] cur = occ.poll();
            int x = cur[0];
            int y = cur[1];
            int t = cur[2];
            for (int d = 0; d < 3; d++) {
                if (t == 1 && d != 1) continue;
                if (t == 0 && d == 2) continue;
                if (t == 2 && d == 0) continue;
                int nx = x + dxys[d][0];
                int ny = y + dxys[d][1];
                if (!isRange(nx, ny) || vis[nx][ny] == 0) continue;
                vis[nx][ny] = 0;
                occ.add(new int[]{nx, ny, t});
            }
        }
        // 시야에 남은 칸의 전사 수
        for (int i = 0; i < N; i++)
            for (int j  = 0; j < N; j++)
                if (vis[i][j] == 1)
                    seen += wm.cell[i][j].size();
        return new VisionResult(vis, seen);
    }




    public static void main(String[] args) {
        // Please write your code here.

        // 0 ~ N-1 범위. 도로는 0 도로가 아니면 1
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        medusaPoint = new Point(sc.nextInt(), sc.nextInt());
        parkPoint = new Point(sc.nextInt(), sc.nextInt());

        List<Point> warriors = new ArrayList<>();
        for (int i = 0; i <  M; i++) {
            warriors.add(new Point(sc.nextInt(), sc.nextInt()));
        }
        map = new int[N][N];
        // 지도 초기화
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                map[i][j] = sc.nextInt();

        // 최단거리 초기화
        dist = bfsDistFromPark(map, medusaPoint);

        // 길이 이어져있지 않으면 0 출력 후 종료
        if (dist[medusaPoint.x][medusaPoint.y] == -1) {
            System.out.println(-1);
            return;
        }

        WarriorMap wm = new WarriorMap(N, warriors);

        while (medusaPoint.equals(parkPoint)) {
            // 1. 메두사 이동
            // 도로를 따라 한칸 이동. 공원까지 최단경로. 이동한 칸에 전사가 있는 경우 전사 사라짐
            // 이동 우선 순위는 상, 하, 좌, 우. 경로가 없을 수도
            moveMedusa();
            if (medusaPoint.equals(parkPoint)) {
                System.out.print(0);
                break;
            }
            // 2. 메두사 시선. 한 방향을 선택해 바라봄
            // 90도의 시야각. 다른 전사에 가려진 전사는 보이지 않음.
            // 상하좌우 대각선 8방향에서 전사가 바라본 동일한 방향으로 보이지 않음
            // 메두사가 바라보면 돌로 변해 현재 턴에는 움직일 수 없다.
            // 같은 칸에 위치할 수 있음
            // 메두사는 상하좌우 중 가장 볼 수 있는 전사가 많은 방향을 바라봄
            int bestSeen = -1;
            int[][] bestVision = null;
            for (int d =0; d < 4; d++) {
                VisionResult vr = buildVision(wm, medusaPoint, VISION[d]);
                if (vr.seen > bestSeen) {
                    bestSeen = vr.seen;
                    bestVision = vr.map;
                }
            }

            // 3. 전사 이동
            int [] res = wm.moveAll(bestVision);
            int step = res[0];
            int attackers = res[1];

            // 턴 출력
            System.out.println(step + " " + bestSeen + " " + attackers);
        }





        // S -> E 로 도로를 따라 최단 경로로 공원까지 이동 - bfs

        // M명의 전사들의 위치는 (r,c) 메두사를 향해 최단 경로로 이동 도로 외로 가도 됨

        // 매턴
        // 1. 메두사 이동
        // 도로를 따라 한칸 이동. 공원까지 최단경로. 이동한 칸에 전사가 있는 경우 전사 사라짐
        // 이동 우선 순위는 상, 하, 좌, 우. 경로가 없을 수도

        // 2. 메두사 시선. 한 방향을 선택해 바라봄
        // 90도의 시야각. 다른 전사에 가려진 전사는 보이지 않음.
        // 상하좌우 대각선 8방향에서 전사가 바라본 동일한 방향으로 보이지 않음
        // 메두사가 바라보면 돌로 변해 현재 턴에는 움직일 수 없다.
        // 같은 칸에 위치할 수 있음
        // 메두사는 상하좌우 중 가장 볼 수 있는 전사가 많은 방향을 바라봄

        // 3. 전사 이동. 돌이 안된 전사는 메두사를 향해 최대 두칸 이동
        // 첫 번째 이동. 거리를 줄일 수 있는 방향으로 이동
        // 방향이 두개 이상일 경우 상, 하, 좌, 우 우선순위
        // 격자 바깥은 갈 수 없고 메두사 시야에는 갈 수 없다.

        // 두 번째 이동. 거리를 줄일 수 있는 방향으로 한칸 더 이동
        // 방향이 두 개 이상일 경우 좌, 우, 상, 하 우선순위
        // 격자 바깥은 갈 수 없고 메두사 시야에는 갈 수 없다.

        // 4. 전사의 공격. 메두사와 같은 칸의 전사는 메두사 공격. 후 사라짐

    }
}

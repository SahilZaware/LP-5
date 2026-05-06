import mpi.*;

public class SumMPI {
    public static void main(String args[]) throws Exception {

        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();   // processor id
        int size = MPI.COMM_WORLD.Size();   // total processors

        int N = 8;
        int[] arr = {1,2,3,4,5,6,7,8};

        int chunk = N / size;
        int start = rank * chunk;
        int end = start + chunk;

        int localSum = 0;

        for(int i = start; i < end; i++) {
            localSum += arr[i];
        }

        System.out.println("Processor " + rank + " local sum = " + localSum);

        int[] globalSum = new int[1];

        MPI.COMM_WORLD.Reduce(
            new int[]{localSum}, 0,
            globalSum, 0,
            1,
            MPI.INT,
            MPI.SUM,
            0
        );

        if(rank == 0) {
            System.out.println("Final Sum = " + globalSum[0]);
        }

        MPI.Finalize();
    }
}
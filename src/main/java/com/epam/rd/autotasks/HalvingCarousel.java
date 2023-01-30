package com.epam.rd.autotasks;

import java.util.List;

public class HalvingCarousel extends DecrementingCarousel {
    //credits goes to https://www.codeproject.com/Questions/5349059/How-to-implement-decrementing-carousel-with-limit

    public HalvingCarousel(final int capacity) {
        super(capacity);

    }
    @Override
    public CarouselRun run() {
        if (!isRun) {
            isRun = true;
            return new HalvingCarouselRun();
        }
        return null;
    }
}
class HalvingCarouselRun extends CarouselRun {
    public int decrement = 2;

    @Override
    public int next() {
        int beforeDecreasing;
        if (isFinished())
            return -1;
        else {
            beforeDecreasing = array[position];
            array[position] = array[position] / decrement;
            do {
                position++;
                if (position == array.length) {
                    position = 0;
                }
            } while(array[position %= array.length] <= 0 && !isFinished());
        }
        return beforeDecreasing;
    }
}


   /*@Override
    public boolean addElement(int element) {
        if (element > 0 && index < capacity && !isRun) {
            carousel[index++] = element;
            return true;
        }
        else
        return false;
    }

    @Override
    public CarouselRun run() {
        if (!isRun) {
            isRun = true;
            return new HalvingCarouselRun();
        }
        return null;
    }

    private class HalvingCarouselRun extends CarouselRun {

        private boolean isHalved = false;

        @Override
        public int next() {
            if (isFinished()) {
                return -1;
            } else {
                while (array[position %= array.length] <= 0) {
                    position++;
                }
            }
            int unhalvedValue = array[position];
            int halvedValue = unhalvedValue / 2;
            array[position++] = isHalved ? halvedValue : unhalvedValue;
            isHalved = !isHalved;
            return isHalved ? halvedValue : unhalvedValue;
        }
    }
}

/*public class HalvingCarousel extends DecrementingCarousel {

    public HalvingCarousel(final int capacity) {
        super(capacity);
    }

    @Override
    public boolean addElement(int element) {
        if (element > 0 && index < capacity && !isRun) {
            carousel[index++] = element;
            return true;
        }
        return false;
    }

    @Override
    public CarouselRun run() {
        if (!isRun) {
            isRun = true;
            return new HalvingCarouselRun();
        }
        return null;
    }

    private class HalvingCarouselRun extends CarouselRun {

        @Override
        public int next() {
            if (isFinished()) {
                return -1;
            } else {
                while (array[position %= array.length] <= 0) {
                    position++;
                }
            }
            int halvedValue = array[position] / 2;
            array[position++] = halvedValue;
            return halvedValue;
        }
    }
}*/

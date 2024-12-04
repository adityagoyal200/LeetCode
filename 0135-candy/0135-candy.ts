function candy(ratings: number[]): number {
    const n = ratings.length;

    if (!ratings || n === 0) {
        return 0;
    }

    let total = 1;
    let i = 1;

    while (i < n) {
        if (ratings[i] === ratings[i - 1]) {
            total++;
            i++;
            continue;
        }

        let peak = 1;
        while (i < n && ratings[i] > ratings[i - 1]) {
            total += ++peak;
            i++;
        }

        let down = 1;
        while (i < n && ratings[i] < ratings[i - 1]) {
            total += down++;
            i++;
        }

        if (peak < down) {
            total += down - peak;
        }
    }

    return total;
}

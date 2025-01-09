function prefixCount(words: string[], pref: string): number {
    if (words == null || words.length === 0) return 0;     
    let cnt = 0;     
    for (let i = 0; i < words.length; i++) {         
        if (words[i].length >= pref.length && words[i].substring(0, pref.length) === pref) {             
            cnt++;         
        }     
    }      
    return cnt; 
};
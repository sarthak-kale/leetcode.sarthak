class Solution {
public:
    void removeCharacter(string &s, char c) {
        s.erase(std::remove(s.begin(), s.end(), c), s.end());
    }
};

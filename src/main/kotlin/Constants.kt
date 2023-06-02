package com.jay.fruitstallthiever

import org.powbot.api.Area
import org.powbot.api.Tile
import org.powbot.api.rt4.TilePath
import org.powbot.api.rt4.World

object Constants {
    val VEOS_DIALOGUE_1 = "I am Veos and I've just arrived in Port Sarim from the distant Kingdom of Great Kourend."
    val VEOS_DIALOGUE_2 = "Certainly! I hope you don't get seasick, it's a long voyage."

    val TILE_VEOS = Tile(3054, 3246, 0)
    val TILE_ARDOUNGE = Tile(2669, 3310, 0)
    val TILE_HOSIDIUS = Tile(1798, 3605, 0)
    val TILE_FISHING_GUILD = Tile(2611, 3389, 0)
    val TILE_DRAYNOR_VILLAGE = Tile(3105, 3251, 0)
    val TILE_PORT_PISCARILIUS = Tile(1824, 3691, 0)
    val TILE_PORT_PISCARILIUS_BOAT = Tile(1824, 3695, 1)
    val TILE_FRUIT_STALL = Tile(1796, 3607, 0)
    val TILE_FRUIT_STALL_DOOR = Tile(1798, 3605, 0)

    val AREA_FRUIT_STALL_HOUSE = Area(Tile(1796, 3609, 0), Tile(1799, 3606))

    val AREA_LUMBY = Area(Tile(3201, 3236, 0), Tile(3230, 3201, 0))

    val PATH_ARDOUNGE = TilePath(arrayOf(Tile(2611, 3389, 0), Tile(2612, 3388, 0),
        Tile(2613, 3387, 0), Tile(2614, 3386, 0), Tile(2615, 3385, 0),
        Tile(2616, 3384, 0), Tile(2617, 3383, 0), Tile(2618, 3382, 0),
        Tile(2619, 3381, 0), Tile(2620, 3380, 0), Tile(2621, 3379, 0),
        Tile(2622, 3378, 0), Tile(2623, 3377, 0), Tile(2624, 3376, 0),
        Tile(2625, 3375, 0), Tile(2626, 3375, 0), Tile(2626, 3374, 0),
        Tile(2626, 3373, 0), Tile(2627, 3373, 0), Tile(2628, 3372, 0),
        Tile(2629, 3372, 0), Tile(2630, 3372, 0), Tile(2631, 3372, 0),
        Tile(2632, 3372, 0), Tile(2633, 3372, 0), Tile(2633, 3371, 0),
        Tile(2634, 3371, 0), Tile(2635, 3371, 0), Tile(2636, 3370, 0),
        Tile(2636, 3369, 0), Tile(2636, 3368, 0), Tile(2636, 3367, 0),
        Tile(2636, 3366, 0), Tile(2636, 3365, 0), Tile(2636, 3364, 0),
        Tile(2636, 3363, 0), Tile(2636, 3362, 0), Tile(2636, 3361, 0),
        Tile(2636, 3360, 0), Tile(2636, 3359, 0), Tile(2636, 3358, 0),
        Tile(2636, 3357, 0), Tile(2636, 3356, 0), Tile(2636, 3355, 0),
        Tile(2636, 3354, 0), Tile(2636, 3353, 0), Tile(2636, 3352, 0),
        Tile(2636, 3351, 0), Tile(2636, 3350, 0), Tile(2636, 3349, 0),
        Tile(2636, 3348, 0), Tile(2636, 3347, 0), Tile(2636, 3346, 0),
        Tile(2636, 3345, 0), Tile(2636, 3344, 0), Tile(2636, 3343, 0),
        Tile(2636, 3342, 0), Tile(2636, 3341, 0), Tile(2636, 3340, 0),
        Tile(2637, 3339, 0), Tile(2638, 3338, 0), Tile(2639, 3337, 0),
        Tile(2640, 3336, 0), Tile(2641, 3335, 0), Tile(2641, 3334, 0),
        Tile(2642, 3333, 0), Tile(2643, 3333, 0), Tile(2644, 3332, 0),
        Tile(2645, 3331, 0), Tile(2646, 3330, 0), Tile(2647, 3329, 0),
        Tile(2647, 3328, 0), Tile(2647, 3327, 0), Tile(2648, 3326, 0),
        Tile(2649, 3325, 0), Tile(2650, 3324, 0), Tile(2651, 3323, 0),
        Tile(2652, 3322, 0), Tile(2652, 3321, 0), Tile(2652, 3320, 0),
        Tile(2652, 3319, 0), Tile(2652, 3318, 0), Tile(2653, 3318, 0),
        Tile(2654, 3318, 0), Tile(2655, 3318, 0), Tile(2656, 3318, 0),
        Tile(2657, 3318, 0), Tile(2658, 3318, 0), Tile(2659, 3318, 0),
        Tile(2660, 3318, 0), Tile(2661, 3318, 0), Tile(2662, 3318, 0),
        Tile(2663, 3318, 0), Tile(2664, 3318, 0), Tile(2665, 3317, 0),
        Tile(2666, 3316, 0), Tile(2667, 3315, 0), Tile(2668, 3314, 0),
        Tile(2669, 3313, 0), Tile(2670, 3312, 0), Tile(2670, 3311, 0),
        Tile(2670, 3310, 0), Tile(2669, 3310, 0)))
    val PATH_VEOS = TilePath(arrayOf(Tile(3105, 3251, 0), Tile(3104, 3250, 0),
        Tile(3103, 3250, 0), Tile(3102, 3250, 0), Tile(3101, 3250, 0),
        Tile(3100, 3250, 0), Tile(3099, 3250, 0), Tile(3098, 3250, 0),
        Tile(3097, 3250, 0), Tile(3096, 3250, 0), Tile(3095, 3250, 0),
        Tile(3094, 3250, 0), Tile(3093, 3250, 0), Tile(3092, 3250, 0),
        Tile(3091, 3250, 0), Tile(3090, 3250, 0), Tile(3089, 3250, 0),
        Tile(3088, 3250, 0), Tile(3087, 3250, 0), Tile(3086, 3250, 0),
        Tile(3085, 3251, 0), Tile(3085, 3252, 0), Tile(3085, 3253, 0),
        Tile(3084, 3253, 0), Tile(3083, 3253, 0), Tile(3082, 3253, 0),
        Tile(3082, 3254, 0), Tile(3082, 3255, 0), Tile(3082, 3256, 0),
        Tile(3082, 3257, 0), Tile(3082, 3258, 0), Tile(3082, 3259, 0),
        Tile(3082, 3260, 0), Tile(3081, 3261, 0), Tile(3080, 3262, 0),
        Tile(3079, 3263, 0), Tile(3078, 3264, 0), Tile(3077, 3265, 0),
        Tile(3077, 3266, 0), Tile(3077, 3267, 0), Tile(3077, 3268, 0),
        Tile(3076, 3268, 0), Tile(3075, 3268, 0), Tile(3075, 3269, 0),
        Tile(3075, 3270, 0), Tile(3075, 3271, 0), Tile(3074, 3272, 0),
        Tile(3073, 3273, 0), Tile(3072, 3274, 0), Tile(3071, 3275, 0),
        Tile(3071, 3276, 0), Tile(3070, 3276, 0), Tile(3069, 3276, 0),
        Tile(3068, 3275, 0), Tile(3067, 3275, 0), Tile(3066, 3275, 0),
        Tile(3065, 3275, 0), Tile(3064, 3274, 0), Tile(3063, 3273, 0),
        Tile(3063, 3272, 0), Tile(3062, 3271, 0), Tile(3061, 3270, 0),
        Tile(3061, 3269, 0), Tile(3061, 3268, 0), Tile(3061, 3267, 0),
        Tile(3061, 3266, 0), Tile(3061, 3265, 0), Tile(3060, 3264, 0),
        Tile(3060, 3263, 0), Tile(3060, 3262, 0), Tile(3059, 3261, 0),
        Tile(3059, 3260, 0), Tile(3058, 3260, 0), Tile(3057, 3259, 0),
        Tile(3057, 3258, 0), Tile(3057, 3257, 0), Tile(3056, 3256, 0),
        Tile(3056, 3255, 0), Tile(3056, 3254, 0), Tile(3055, 3253, 0),
        Tile(3054, 3252, 0), Tile(3054, 3251, 0), Tile(3054, 3250, 0),
        Tile(3054, 3249, 0), Tile(3054, 3248, 0), Tile(3054, 3247, 0),
        Tile(3054, 3246, 0)))
    val PATH_HOSIDIUS = TilePath(arrayOf(Tile(1824, 3691, 0), Tile(1824, 3690, 0),
        Tile(1823, 3690, 0), Tile(1822, 3690, 0), Tile(1821, 3690, 0),
        Tile(1820, 3690, 0), Tile(1819, 3690, 0), Tile(1818, 3690, 0),
        Tile(1817, 3690, 0), Tile(1816, 3690, 0), Tile(1815, 3690, 0),
        Tile(1814, 3690, 0), Tile(1813, 3690, 0), Tile(1812, 3690, 0),
        Tile(1811, 3690, 0), Tile(1810, 3690, 0), Tile(1809, 3690, 0),
        Tile(1808, 3690, 0), Tile(1807, 3690, 0), Tile(1806, 3690, 0),
        Tile(1805, 3690, 0), Tile(1804, 3690, 0), Tile(1803, 3690, 0),
        Tile(1802, 3690, 0), Tile(1801, 3690, 0), Tile(1800, 3690, 0),
        Tile(1799, 3690, 0), Tile(1798, 3690, 0), Tile(1797, 3690, 0),
        Tile(1796, 3690, 0), Tile(1795, 3690, 0), Tile(1794, 3690, 0),
        Tile(1793, 3690, 0), Tile(1792, 3689, 0), Tile(1791, 3688, 0),
        Tile(1790, 3688, 0), Tile(1789, 3688, 0), Tile(1788, 3688, 0),
        Tile(1788, 3687, 0), Tile(1788, 3686, 0), Tile(1788, 3685, 0),
        Tile(1788, 3684, 0), Tile(1788, 3683, 0), Tile(1788, 3682, 0),
        Tile(1788, 3681, 0), Tile(1789, 3680, 0), Tile(1790, 3679, 0),
        Tile(1790, 3678, 0), Tile(1790, 3677, 0), Tile(1791, 3676, 0),
        Tile(1792, 3675, 0), Tile(1792, 3674, 0), Tile(1793, 3673, 0),
        Tile(1793, 3672, 0), Tile(1793, 3671, 0), Tile(1793, 3670, 0),
        Tile(1793, 3669, 0), Tile(1793, 3668, 0), Tile(1793, 3667, 0),
        Tile(1793, 3666, 0), Tile(1793, 3665, 0), Tile(1793, 3664, 0),
        Tile(1793, 3663, 0), Tile(1793, 3662, 0), Tile(1793, 3661, 0),
        Tile(1793, 3660, 0), Tile(1793, 3659, 0), Tile(1793, 3658, 0),
        Tile(1793, 3657, 0), Tile(1793, 3656, 0), Tile(1793, 3655, 0),
        Tile(1793, 3654, 0), Tile(1793, 3653, 0), Tile(1793, 3652, 0),
        Tile(1793, 3651, 0), Tile(1793, 3650, 0), Tile(1793, 3649, 0),
        Tile(1793, 3648, 0), Tile(1793, 3647, 0), Tile(1793, 3646, 0),
        Tile(1793, 3645, 0), Tile(1793, 3644, 0), Tile(1793, 3643, 0),
        Tile(1793, 3642, 0), Tile(1793, 3641, 0), Tile(1793, 3640, 0),
        Tile(1793, 3639, 0), Tile(1793, 3638, 0), Tile(1793, 3637, 0),
        Tile(1793, 3636, 0), Tile(1793, 3635, 0), Tile(1793, 3634, 0),
        Tile(1793, 3633, 0), Tile(1793, 3632, 0), Tile(1793, 3631, 0),
        Tile(1793, 3630, 0), Tile(1793, 3629, 0), Tile(1793, 3628, 0),
        Tile(1793, 3627, 0), Tile(1793, 3626, 0), Tile(1793, 3625, 0),
        Tile(1793, 3624, 0), Tile(1793, 3623, 0), Tile(1793, 3622, 0),
        Tile(1793, 3621, 0), Tile(1793, 3620, 0), Tile(1793, 3619, 0),
        Tile(1793, 3618, 0), Tile(1793, 3617, 0), Tile(1793, 3616, 0),
        Tile(1793, 3615, 0), Tile(1793, 3614, 0), Tile(1793, 3613, 0),
        Tile(1793, 3612, 0), Tile(1793, 3611, 0), Tile(1793, 3610, 0),
        Tile(1793, 3609, 0), Tile(1793, 3608, 0), Tile(1793, 3607, 0),
        Tile(1793, 3606, 0), Tile(1794, 3605, 0), Tile(1795, 3605, 0),
        Tile(1796, 3605, 0), Tile(1797, 3605, 0), Tile(1798, 3605, 0)))

    // Hosidius favour - Ploughing
    val TILE_PLOUGHING = Tile(1770, 3550, 0)
    val AREA_PLOUGHING = Area(Tile(1762, 3557, 0), Tile(1780, 3543, 0))
    val PATH_PLOUGHING = TilePath(arrayOf(Tile(1824, 3691, 0), Tile(1824, 3690, 0),
        Tile(1823, 3690, 0), Tile(1822, 3690, 0), Tile(1821, 3690, 0),
        Tile(1820, 3690, 0), Tile(1819, 3690, 0), Tile(1818, 3690, 0),
        Tile(1817, 3690, 0), Tile(1816, 3690, 0), Tile(1815, 3690, 0),
        Tile(1814, 3690, 0), Tile(1813, 3690, 0), Tile(1812, 3690, 0),
        Tile(1811, 3690, 0), Tile(1810, 3690, 0), Tile(1809, 3690, 0),
        Tile(1808, 3690, 0), Tile(1807, 3690, 0), Tile(1806, 3690, 0),
        Tile(1805, 3690, 0), Tile(1804, 3690, 0), Tile(1803, 3690, 0),
        Tile(1802, 3690, 0), Tile(1801, 3690, 0), Tile(1800, 3690, 0),
        Tile(1799, 3690, 0), Tile(1798, 3690, 0), Tile(1797, 3690, 0),
        Tile(1796, 3690, 0), Tile(1795, 3690, 0), Tile(1794, 3690, 0),
        Tile(1793, 3690, 0), Tile(1792, 3689, 0), Tile(1791, 3688, 0),
        Tile(1790, 3688, 0), Tile(1789, 3688, 0), Tile(1788, 3688, 0),
        Tile(1787, 3687, 0), Tile(1786, 3686, 0), Tile(1785, 3685, 0),
        Tile(1784, 3684, 0), Tile(1783, 3683, 0), Tile(1782, 3682, 0),
        Tile(1781, 3681, 0), Tile(1780, 3680, 0), Tile(1779, 3679, 0),
        Tile(1779, 3678, 0), Tile(1779, 3677, 0), Tile(1778, 3676, 0),
        Tile(1777, 3676, 0), Tile(1776, 3676, 0), Tile(1775, 3676, 0),
        Tile(1774, 3676, 0), Tile(1773, 3676, 0), Tile(1772, 3675, 0),
        Tile(1772, 3674, 0), Tile(1771, 3673, 0), Tile(1771, 3672, 0),
        Tile(1771, 3671, 0), Tile(1771, 3670, 0), Tile(1771, 3669, 0),
        Tile(1771, 3668, 0), Tile(1771, 3667, 0), Tile(1771, 3666, 0),
        Tile(1771, 3665, 0), Tile(1771, 3664, 0), Tile(1771, 3663, 0),
        Tile(1771, 3662, 0), Tile(1771, 3661, 0), Tile(1771, 3660, 0),
        Tile(1771, 3659, 0), Tile(1771, 3658, 0), Tile(1771, 3657, 0),
        Tile(1771, 3656, 0), Tile(1771, 3655, 0), Tile(1771, 3654, 0),
        Tile(1771, 3653, 0), Tile(1771, 3652, 0), Tile(1771, 3651, 0),
        Tile(1771, 3650, 0), Tile(1771, 3649, 0), Tile(1771, 3648, 0),
        Tile(1771, 3647, 0), Tile(1771, 3646, 0), Tile(1771, 3645, 0),
        Tile(1771, 3644, 0), Tile(1771, 3643, 0), Tile(1771, 3642, 0),
        Tile(1771, 3641, 0), Tile(1771, 3640, 0), Tile(1771, 3639, 0),
        Tile(1771, 3638, 0), Tile(1771, 3637, 0), Tile(1771, 3636, 0),
        Tile(1771, 3635, 0), Tile(1771, 3634, 0), Tile(1771, 3633, 0),
        Tile(1771, 3632, 0), Tile(1771, 3631, 0), Tile(1771, 3630, 0),
        Tile(1771, 3629, 0), Tile(1771, 3628, 0), Tile(1770, 3627, 0),
        Tile(1770, 3626, 0), Tile(1770, 3625, 0), Tile(1770, 3624, 0),
        Tile(1771, 3624, 0), Tile(1771, 3623, 0), Tile(1771, 3622, 0),
        Tile(1771, 3621, 0), Tile(1771, 3620, 0), Tile(1770, 3620, 0),
        Tile(1769, 3620, 0), Tile(1769, 3619, 0), Tile(1769, 3618, 0),
        Tile(1769, 3617, 0), Tile(1768, 3616, 0), Tile(1768, 3615, 0),
        Tile(1768, 3614, 0), Tile(1768, 3613, 0), Tile(1768, 3612, 0),
        Tile(1767, 3611, 0), Tile(1766, 3610, 0), Tile(1766, 3609, 0),
        Tile(1766, 3608, 0), Tile(1766, 3607, 0), Tile(1766, 3606, 0),
        Tile(1765, 3605, 0), Tile(1765, 3604, 0), Tile(1765, 3603, 0),
        Tile(1765, 3602, 0), Tile(1765, 3601, 0), Tile(1765, 3600, 0),
        Tile(1765, 3599, 0), Tile(1765, 3598, 0), Tile(1765, 3597, 0),
        Tile(1765, 3596, 0), Tile(1765, 3595, 0), Tile(1765, 3594, 0),
        Tile(1765, 3593, 0), Tile(1764, 3592, 0), Tile(1763, 3591, 0),
        Tile(1763, 3590, 0), Tile(1763, 3589, 0), Tile(1763, 3588, 0),
        Tile(1762, 3587, 0), Tile(1761, 3586, 0), Tile(1760, 3585, 0),
        Tile(1760, 3584, 0), Tile(1759, 3583, 0), Tile(1759, 3582, 0),
        Tile(1759, 3581, 0), Tile(1759, 3580, 0), Tile(1759, 3579, 0),
        Tile(1760, 3578, 0), Tile(1760, 3577, 0), Tile(1760, 3576, 0),
        Tile(1760, 3575, 0), Tile(1760, 3574, 0), Tile(1760, 3573, 0),
        Tile(1760, 3572, 0), Tile(1760, 3571, 0), Tile(1760, 3570, 0),
        Tile(1760, 3569, 0), Tile(1760, 3568, 0), Tile(1760, 3567, 0),
        Tile(1760, 3566, 0), Tile(1760, 3565, 0), Tile(1760, 3564, 0),
        Tile(1760, 3563, 0), Tile(1760, 3562, 0), Tile(1760, 3561, 0),
        Tile(1760, 3560, 0), Tile(1760, 3559, 0), Tile(1760, 3558, 0),
        Tile(1760, 3557, 0), Tile(1760, 3556, 0), Tile(1760, 3555, 0),
        Tile(1760, 3554, 0), Tile(1760, 3553, 0), Tile(1760, 3552, 0),
        Tile(1761, 3551, 0), Tile(1762, 3550, 0), Tile(1763, 3550, 0),
        Tile(1764, 3550, 0), Tile(1765, 3550, 0), Tile(1766, 3550, 0),
        Tile(1767, 3550, 0), Tile(1768, 3550, 0), Tile(1769, 3550, 0),
        Tile(1770, 3550, 0)))

    // World-hopping
    val WORLD_SPECIALITY_FILTER = arrayOf(World.Specialty.BOUNTY_HUNTER, World.Specialty.TARGET_WORLD,
        World.Specialty.FRESH_START, World.Specialty.HIGH_RISK, World.Specialty.BETA, World.Specialty.DEAD_MAN,
        World.Specialty.LEAGUE, World.Specialty.PVP_ARENA, World.Specialty.SKILL_REQUIREMENT,
        World.Specialty.SPEEDRUNNING, World.Specialty.TWISTED_LEAGUE)
}
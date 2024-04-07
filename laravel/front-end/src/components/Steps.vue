<template>
    <div class="max-w-lg mx-auto px-4 sm:px-0">
        <ul aria-label="Steps" class="flex items-center">
            <li v-for="(item, idx) in stepsCount" :key="idx" :aria-current="currentStep == idx + 1 ? 'step' : false" class="flex-1 last:flex-none flex items-center">
                <div :class="{'w-8 h-8 rounded-full border-2 flex-none flex items-center justify-center': true, 'bg-indigo-600 border-indigo-600': currentStep > idx + 1, 'border-indigo-600': currentStep == idx + 1}">
                    <span :class="{'w-2.5 h-2.5 rounded-full bg-indigo-600': true, 'hidden': currentStep != idx + 1}"></span>
                    <template v-if="currentStep > idx + 1">
                        <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-5 h-5 text-white">
                            <path stroke-linecap="round" stroke-linejoin="round" d="M4.5 12.75l6 6 9-13.5" />
                        </svg>
                    </template>
                </div>
                <hr :class="{'w-full border': true, 'hidden': idx + 1 == stepsCount.length, 'border-indigo-600': currentStep > idx + 1}" />
            </li>
        </ul>
    </div>
</template>

<script>
export default {
    data() {
        return {
            stepsCount: [1, 2, 3, 4],
            currentStep: 2
        }
    }
}
</script>

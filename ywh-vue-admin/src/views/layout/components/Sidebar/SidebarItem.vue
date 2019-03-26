<template>
  <div v-if="!item.hidden&&item.children" class="menu-wrapper">

    <router-link v-if="hasOneShowingChild(item.children) && !onlyOneChild.children&&!item.alwaysShow" :to="resolvePath(onlyOneChild.path)">
      <el-menu-item :index="resolvePath(onlyOneChild.path)" :class="{'submenu-title-noDropdown':!isNest}">
        <svg-icon v-if="onlyOneChild.meta&&onlyOneChild.meta.icon" :icon-class="onlyOneChild.meta.icon"/>
        <span v-if="onlyOneChild.meta&&onlyOneChild.meta.title" slot="title">{{ onlyOneChild.meta.title }}</span>
      </el-menu-item>
    </router-link>

    <el-submenu v-else :index="item.name||item.path">
      <template slot="title">
        <svg-icon v-if="item.meta&&item.meta.icon" :icon-class="item.meta.icon"/>
        <span v-if="item.meta&&item.meta.title" slot="title">{{ item.meta.title }}</span>
      </template>

      <template v-for="child in visibleChildren">
        <sidebar-item
          v-if="child.children&&child.children.length>0"
          :is-nest="true"
          :item="child"
          :key="child.path"
          :base-path="resolvePath(child.path)"
          class="nest-menu"/>

        <router-link v-else :to="resolvePath(child.path)" :key="child.name">
          <el-menu-item :index="resolvePath(child.path)">
            <svg-icon v-if="child.meta&&child.meta.icon" :icon-class="child.meta.icon"/>
            <span v-if="child.meta&&child.meta.title" slot="title">{{ child.meta.title }}</span>
          </el-menu-item>
        </router-link>
      </template>
    </el-submenu>

  </div>
</template>

<script>
import path from 'path'

export default {
  name: 'SidebarItem',
  props: {
    // route配置json
    item: {
      type: Object,
      required: true
    },
    isNest: {
      type: Boolean,
      default: false
    },
    basePath: {
      type: String,
      default: ''
    }
  },
  data() {
    return {
      onlyOneChild: null
    }
  },
  // 这个是解决上面v-if和v-for不能混合使用的方法，之前是v-for(child in item.child) v-if(!item.hidden),需要把一方放在计算属性中，而v-for比v-if的优先级高，所以把v-if放下来
  computed: {
    visibleChildren() {
      return this.item.children.filter(child => !child.hidden)
    }
  },
  methods: {
    hasOneShowingChild(children) {
      const showingChildren = children.filter(item => {
        if (item.hidden) {
          return false
        } else {
          // temp set(will be used if only has one showing child )
          this.onlyOneChild = item
          return true
        }
      })
      if (showingChildren.length === 1) {
        return true
      }
      return false
    },
    resolvePath(...paths) {
      return path.resolve(this.basePath, ...paths)
    }
  }
}
</script>

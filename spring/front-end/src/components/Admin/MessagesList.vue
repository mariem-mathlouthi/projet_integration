<!-- App.vue -->
<template>
 <div id="app">
    <!-- SIDEBAR -->
    <SidebarMenu></SidebarMenu>

    <!-- CONTENT -->
    <section id="content">
      <!-- NAVBAR -->
      <NavbarOne></NavbarOne>
<section class="chat-section">
        <div class="chat-container">
            <!-- start: Sidebar -->
            <aside class="chat-sidebar">
                <a href="#" class="chat-sidebar-logo">
                    <i class="ri-chat-1-fill"></i>
                </a>
                <ul class="chat-sidebar-menu">
                    <li class="active"><a href="#" data-title="Chats"><i class="ri-chat-3-line"></i></a></li>
                    <li><a href="#" data-title="Contacts"><i class="ri-contacts-line"></i></a></li>
                    <li><a href="#" data-title="Documents"><i class="ri-folder-line"></i></a></li>
                    <li><a href="#" data-title="Settings"><i class="ri-settings-line"></i></a></li>
                    <li class="chat-sidebar-profile">
                        <button type="button" class="chat-sidebar-profile-toggle">
                            <img src="https://images.unsplash.com/photo-1534528741775-53994a69daeb?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OXx8cGVvcGxlfGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60" alt="">
                        </button>
                        <ul class="chat-sidebar-profile-dropdown">
                            <li><a href="#"><i class="ri-user-line"></i> Profile</a></li>
                            <li><a href="#"><i class="ri-logout-box-line"></i> Logout</a></li>
                        </ul>
                    </li>
                </ul>
            </aside>
            <!-- end: Sidebar -->
            <!-- start: Content -->
            <div class="chat-content">
                <!-- start: Content side -->
                <div class="content-sidebar">
                    <div class="content-sidebar-title">Chats</div>
                    <form action="" class="content-sidebar-form">
                        <input type="search" class="content-sidebar-input" placeholder="Search...">
                        <button type="submit" class="content-sidebar-submit"><i class="ri-search-line"></i></button>
                    </form>
                    <div class="content-messages">
                        <ul class="content-messages-list">
                            <li class="content-message-title"><span>Recently</span></li>
                            <li>
                                <a href="#" data-conversation="#conversation-1">
                                    <img class="content-message-image" src="https://images.unsplash.com/photo-1534528741775-53994a69daeb?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OXx8cGVvcGxlfGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60" alt="">
                                    <span class="content-message-info">
                                        <span class="content-message-name">Someone</span>
                                        <span class="content-message-text">Lorem ipsum dolor sit amet consectetur.</span>
                                    </span>
                                    <span class="content-message-more">
                                        <span class="content-message-unread">5</span>
                                        <span class="content-message-time">12:30</span>
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="#" data-conversation="#conversation-2">
                                    <img class="content-message-image" src="https://images.unsplash.com/photo-1534528741775-53994a69daeb?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OXx8cGVvcGxlfGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60" alt="">
                                    <span class="content-message-info">
                                        <span class="content-message-name">Someone</span>
                                        <span class="content-message-text">Lorem ipsum dolor sit amet consectetur.</span>
                                    </span>
                                    <span class="content-message-more">
                                        <span class="content-message-time">12:30</span>
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <img class="content-message-image" src="https://images.unsplash.com/photo-1534528741775-53994a69daeb?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OXx8cGVvcGxlfGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60" alt="">
                                    <span class="content-message-info">
                                        <span class="content-message-name">Someone</span>
                                        <span class="content-message-text">Lorem ipsum dolor sit amet consectetur.</span>
                                    </span>
                                    <span class="content-message-more">
                                        <span class="content-message-unread">5</span>
                                        <span class="content-message-time">12:30</span>
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <img class="content-message-image" src="https://images.unsplash.com/photo-1534528741775-53994a69daeb?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OXx8cGVvcGxlfGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60" alt="">
                                    <span class="content-message-info">
                                        <span class="content-message-name">Someone</span>
                                        <span class="content-message-text">Lorem ipsum dolor sit amet consectetur.</span>
                                    </span>
                                    <span class="content-message-more">
                                        <span class="content-message-time">12:30</span>
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <img class="content-message-image" src="https://images.unsplash.com/photo-1534528741775-53994a69daeb?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OXx8cGVvcGxlfGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60" alt="">
                                    <span class="content-message-info">
                                        <span class="content-message-name">Someone</span>
                                        <span class="content-message-text">Lorem ipsum dolor sit amet consectetur.</span>
                                    </span>
                                    <span class="content-message-more">
                                        <span class="content-message-unread">5</span>
                                        <span class="content-message-time">12:30</span>
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <img class="content-message-image" src="https://images.unsplash.com/photo-1534528741775-53994a69daeb?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OXx8cGVvcGxlfGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60" alt="">
                                    <span class="content-message-info">
                                        <span class="content-message-name">Someone</span>
                                        <span class="content-message-text">Lorem ipsum dolor sit amet consectetur.</span>
                                    </span>
                                    <span class="content-message-more">
                                        <span class="content-message-time">12:30</span>
                                    </span>
                                </a>
                            </li>
                        </ul>
                        <ul class="content-messages-list">
                            <li class="content-message-title"><span>Recently</span></li>
                            <li>
                                <a href="#">
                                    <img class="content-message-image" src="https://images.unsplash.com/photo-1534528741775-53994a69daeb?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OXx8cGVvcGxlfGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60" alt="">
                                    <span class="content-message-info">
                                        <span class="content-message-name">Someone</span>
                                        <span class="content-message-text">Lorem ipsum dolor sit amet consectetur.</span>
                                    </span>
                                    <span class="content-message-more">
                                        <span class="content-message-unread">5</span>
                                        <span class="content-message-time">12:30</span>
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <img class="content-message-image" src="https://images.unsplash.com/photo-1534528741775-53994a69daeb?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OXx8cGVvcGxlfGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60" alt="">
                                    <span class="content-message-info">
                                        <span class="content-message-name">Someone</span>
                                        <span class="content-message-text">Lorem ipsum dolor sit amet consectetur.</span>
                                    </span>
                                    <span class="content-message-more">
                                        <span class="content-message-time">12:30</span>
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <img class="content-message-image" src="https://images.unsplash.com/photo-1534528741775-53994a69daeb?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OXx8cGVvcGxlfGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60" alt="">
                                    <span class="content-message-info">
                                        <span class="content-message-name">Someone</span>
                                        <span class="content-message-text">Lorem ipsum dolor sit amet consectetur.</span>
                                    </span>
                                    <span class="content-message-more">
                                        <span class="content-message-unread">5</span>
                                        <span class="content-message-time">12:30</span>
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <img class="content-message-image" src="https://images.unsplash.com/photo-1534528741775-53994a69daeb?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OXx8cGVvcGxlfGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60" alt="">
                                    <span class="content-message-info">
                                        <span class="content-message-name">Someone</span>
                                        <span class="content-message-text">Lorem ipsum dolor sit amet consectetur.</span>
                                    </span>
                                    <span class="content-message-more">
                                        <span class="content-message-time">12:30</span>
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <img class="content-message-image" src="https://images.unsplash.com/photo-1534528741775-53994a69daeb?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OXx8cGVvcGxlfGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60" alt="">
                                    <span class="content-message-info">
                                        <span class="content-message-name">Someone</span>
                                        <span class="content-message-text">Lorem ipsum dolor sit amet consectetur.</span>
                                    </span>
                                    <span class="content-message-more">
                                        <span class="content-message-unread">5</span>
                                        <span class="content-message-time">12:30</span>
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <img class="content-message-image" src="https://images.unsplash.com/photo-1534528741775-53994a69daeb?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OXx8cGVvcGxlfGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60" alt="">
                                    <span class="content-message-info">
                                        <span class="content-message-name">Someone</span>
                                        <span class="content-message-text">Lorem ipsum dolor sit amet consectetur.</span>
                                    </span>
                                    <span class="content-message-more">
                                        <span class="content-message-time">12:30</span>
                                    </span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
                <!-- end: Content side -->
                <!-- start: Conversation -->
                <div class="conversation conversation-default active">
                    <i class="ri-chat-3-line"></i>
                    <p>Select chat and view conversation!</p>
                </div>
                <div class="conversation" id="conversation-1">
                    <div class="conversation-top">
                        <button type="button" class="conversation-back"><i class="ri-arrow-left-line"></i></button>
                        <div class="conversation-user">
                            <img class="conversation-user-image" src="https://images.unsplash.com/photo-1534528741775-53994a69daeb?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OXx8cGVvcGxlfGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60" alt="">
                            <div>
                                <div class="conversation-user-name">Someone</div>
                                <div class="conversation-user-status online">online</div>
                            </div>
                        </div>
                        <div class="conversation-buttons">
                            <button type="button"><i class="ri-phone-fill"></i></button>
                            <button type="button"><i class="ri-vidicon-line"></i></button>
                            <button type="button"><i class="ri-information-line"></i></button>
                        </div>
                    </div>
                    <div class="conversation-main">
                        <ul class="conversation-wrapper">
                            <div class="coversation-divider"><span>Today</span></div>
                            <li class="conversation-item me">
                                <div class="conversation-item-side">
                                    <img class="conversation-item-image" src="https://images.unsplash.com/photo-1534528741775-53994a69daeb?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OXx8cGVvcGxlfGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60" alt="">
                                </div>
                                <div class="conversation-item-content">
                                    <div class="conversation-item-wrapper">
                                        <div class="conversation-item-box">
                                            <div class="conversation-item-text">
                                                <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Amet natus repudiandae quisquam sequi nobis suscipit consequatur rerum alias odio repellat!</p>
                                                <div class="conversation-item-time">12:30</div>
                                            </div>
                                            <div class="conversation-item-dropdown">
                                                <button type="button" class="conversation-item-dropdown-toggle"><i class="ri-more-2-line"></i></button>
                                                <ul class="conversation-item-dropdown-list">
                                                    <li><a href="#"><i class="ri-share-forward-line"></i> Forward</a></li>
                                                    <li><a href="#"><i class="ri-delete-bin-line"></i> Delete</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="conversation-item-wrapper">
                                        <div class="conversation-item-box">
                                            <div class="conversation-item-text">
                                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Eaque, tenetur!</p>
                                                <div class="conversation-item-time">12:30</div>
                                            </div>
                                            <div class="conversation-item-dropdown">
                                                <button type="button" class="conversation-item-dropdown-toggle"><i class="ri-more-2-line"></i></button>
                                                <ul class="conversation-item-dropdown-list">
                                                    <li><a href="#"><i class="ri-share-forward-line"></i> Forward</a></li>
                                                    <li><a href="#"><i class="ri-delete-bin-line"></i> Delete</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li class="conversation-item">
                                <div class="conversation-item-side">
                                    <img class="conversation-item-image" src="https://images.unsplash.com/photo-1534528741775-53994a69daeb?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OXx8cGVvcGxlfGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60" alt="">
                                </div>
                                <div class="conversation-item-content">
                                    <div class="conversation-item-wrapper">
                                        <div class="conversation-item-box">
                                            <div class="conversation-item-text">
                                                <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit.</p>
                                                <div class="conversation-item-time">12:30</div>
                                            </div>
                                            <div class="conversation-item-dropdown">
                                                <button type="button" class="conversation-item-dropdown-toggle"><i class="ri-more-2-line"></i></button>
                                                <ul class="conversation-item-dropdown-list">
                                                    <li><a href="#"><i class="ri-share-forward-line"></i> Forward</a></li>
                                                    <li><a href="#"><i class="ri-delete-bin-line"></i> Delete</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="conversation-item-wrapper">
                                        <div class="conversation-item-box">
                                            <div class="conversation-item-text">
                                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Atque eos ab in?</p>
                                                <div class="conversation-item-time">12:30</div>
                                            </div>
                                            <div class="conversation-item-dropdown">
                                                <button type="button" class="conversation-item-dropdown-toggle"><i class="ri-more-2-line"></i></button>
                                                <ul class="conversation-item-dropdown-list">
                                                    <li><a href="#"><i class="ri-share-forward-line"></i> Forward</a></li>
                                                    <li><a href="#"><i class="ri-delete-bin-line"></i> Delete</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="conversation-item-wrapper">
                                        <div class="conversation-item-box">
                                            <div class="conversation-item-text">
                                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Sint, debitis. Iste natus est aliquam ipsum doloremque fugiat, quidem eos autem? Dolor quisquam laboriosam enim cum laborum suscipit perferendis adipisci praesentium.</p>
                                                <div class="conversation-item-time">12:30</div>
                                            </div>
                                            <div class="conversation-item-dropdown">
                                                <button type="button" class="conversation-item-dropdown-toggle"><i class="ri-more-2-line"></i></button>
                                                <ul class="conversation-item-dropdown-list">
                                                    <li><a href="#"><i class="ri-share-forward-line"></i> Forward</a></li>
                                                    <li><a href="#"><i class="ri-delete-bin-line"></i> Delete</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li class="conversation-item me">
                                <div class="conversation-item-side">
                                    <img class="conversation-item-image" src="https://images.unsplash.com/photo-1534528741775-53994a69daeb?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OXx8cGVvcGxlfGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60" alt="">
                                </div>
                                <div class="conversation-item-content">
                                    <div class="conversation-item-wrapper">
                                        <div class="conversation-item-box">
                                            <div class="conversation-item-text">
                                                <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Quas, eos, magni temporibus, placeat consectetur nobis incidunt dicta a culpa vel esse. Facilis fugiat possimus eveniet accusamus dignissimos pariatur inventore animi rem vero, eligendi obcaecati fugit quaerat? Officia ex quod eaque maxime ipsam, tempore error laboriosam laborum, magnam ipsum doloremque quas.</p>
                                                <div class="conversation-item-time">12:30</div>
                                            </div>
                                            <div class="conversation-item-dropdown">
                                                <button type="button" class="conversation-item-dropdown-toggle"><i class="ri-more-2-line"></i></button>
                                                <ul class="conversation-item-dropdown-list">
                                                    <li><a href="#"><i class="ri-share-forward-line"></i> Forward</a></li>
                                                    <li><a href="#"><i class="ri-delete-bin-line"></i> Delete</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="conversation-item-wrapper">
                                        <div class="conversation-item-box">
                                            <div class="conversation-item-text">
                                                <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Temporibus debitis odio maiores perferendis ipsa repudiandae amet blanditiis quod. Ullam, dolorum.</p>
                                                <div class="conversation-item-time">12:30</div>
                                            </div>
                                            <div class="conversation-item-dropdown">
                                                <button type="button" class="conversation-item-dropdown-toggle"><i class="ri-more-2-line"></i></button>
                                                <ul class="conversation-item-dropdown-list">
                                                    <li><a href="#"><i class="ri-share-forward-line"></i> Forward</a></li>
                                                    <li><a href="#"><i class="ri-delete-bin-line"></i> Delete</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="conversation-item-wrapper">
                                        <div class="conversation-item-box">
                                            <div class="conversation-item-text">
                                                <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Accusantium blanditiis ea, voluptatum, eveniet at harum minima maxime enim aut non, iure expedita excepturi tempore nostrum quasi natus voluptas dolore ducimus!</p>
                                                <div class="conversation-item-time">12:30</div>
                                            </div>
                                            <div class="conversation-item-dropdown">
                                                <button type="button" class="conversation-item-dropdown-toggle"><i class="ri-more-2-line"></i></button>
                                                <ul class="conversation-item-dropdown-list">
                                                    <li><a href="#"><i class="ri-share-forward-line"></i> Forward</a></li>
                                                    <li><a href="#"><i class="ri-delete-bin-line"></i> Delete</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="conversation-form">
                        <button type="button" class="conversation-form-button"><i class="ri-emotion-line"></i></button>
                        <div class="conversation-form-group">
                            <textarea class="conversation-form-input" rows="1" placeholder="Type here..."></textarea>
                            <button type="button" class="conversation-form-record"><i class="ri-mic-line"></i></button>
                        </div>
                        <button type="button" class="conversation-form-button conversation-form-submit"><i class="ri-send-plane-2-line"></i></button>
                    </div>
                </div>
                <div class="conversation" id="conversation-2">
                    <div class="conversation-top">
                        <button type="button" class="conversation-back"><i class="ri-arrow-left-line"></i></button>
                        <div class="conversation-user">
                            <img class="conversation-user-image" src="https://images.unsplash.com/photo-1534528741775-53994a69daeb?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OXx8cGVvcGxlfGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60" alt="">
                            <div>
                                <div class="conversation-user-name">Someone 1</div>
                                <div class="conversation-user-status online">online</div>
                            </div>
                        </div>
                        <div class="conversation-buttons">
                            <button type="button"><i class="ri-phone-fill"></i></button>
                            <button type="button"><i class="ri-vidicon-line"></i></button>
                            <button type="button"><i class="ri-information-line"></i></button>
                        </div>
                    </div>
                    <div class="conversation-main">
                        <ul class="conversation-wrapper">
                            <div class="coversation-divider"><span>Today</span></div>
                            <li class="conversation-item me">
                                <div class="conversation-item-side">
                                    <img class="conversation-item-image" src="https://images.unsplash.com/photo-1534528741775-53994a69daeb?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OXx8cGVvcGxlfGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60" alt="">
                                </div>
                                <div class="conversation-item-content">
                                    <div class="conversation-item-wrapper">
                                        <div class="conversation-item-box">
                                            <div class="conversation-item-text">
                                                <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Amet natus repudiandae quisquam sequi nobis suscipit consequatur rerum alias odio repellat!</p>
                                                <div class="conversation-item-time">12:30</div>
                                            </div>
                                            <div class="conversation-item-dropdown">
                                                <button type="button" class="conversation-item-dropdown-toggle"><i class="ri-more-2-line"></i></button>
                                                <ul class="conversation-item-dropdown-list">
                                                    <li><a href="#"><i class="ri-share-forward-line"></i> Forward</a></li>
                                                    <li><a href="#"><i class="ri-delete-bin-line"></i> Delete</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="conversation-item-wrapper">
                                        <div class="conversation-item-box">
                                            <div class="conversation-item-text">
                                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Eaque, tenetur!</p>
                                                <div class="conversation-item-time">12:30</div>
                                            </div>
                                            <div class="conversation-item-dropdown">
                                                <button type="button" class="conversation-item-dropdown-toggle"><i class="ri-more-2-line"></i></button>
                                                <ul class="conversation-item-dropdown-list">
                                                    <li><a href="#"><i class="ri-share-forward-line"></i> Forward</a></li>
                                                    <li><a href="#"><i class="ri-delete-bin-line"></i> Delete</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li class="conversation-item">
                                <div class="conversation-item-side">
                                    <img class="conversation-item-image" src="https://images.unsplash.com/photo-1534528741775-53994a69daeb?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OXx8cGVvcGxlfGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60" alt="">
                                </div>
                                <div class="conversation-item-content">
                                    <div class="conversation-item-wrapper">
                                        <div class="conversation-item-box">
                                            <div class="conversation-item-text">
                                                <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit.</p>
                                                <div class="conversation-item-time">12:30</div>
                                            </div>
                                            <div class="conversation-item-dropdown">
                                                <button type="button" class="conversation-item-dropdown-toggle"><i class="ri-more-2-line"></i></button>
                                                <ul class="conversation-item-dropdown-list">
                                                    <li><a href="#"><i class="ri-share-forward-line"></i> Forward</a></li>
                                                    <li><a href="#"><i class="ri-delete-bin-line"></i> Delete</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="conversation-item-wrapper">
                                        <div class="conversation-item-box">
                                            <div class="conversation-item-text">
                                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Atque eos ab in?</p>
                                                <div class="conversation-item-time">12:30</div>
                                            </div>
                                            <div class="conversation-item-dropdown">
                                                <button type="button" class="conversation-item-dropdown-toggle"><i class="ri-more-2-line"></i></button>
                                                <ul class="conversation-item-dropdown-list">
                                                    <li><a href="#"><i class="ri-share-forward-line"></i> Forward</a></li>
                                                    <li><a href="#"><i class="ri-delete-bin-line"></i> Delete</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="conversation-item-wrapper">
                                        <div class="conversation-item-box">
                                            <div class="conversation-item-text">
                                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Sint, debitis. Iste natus est aliquam ipsum doloremque fugiat, quidem eos autem? Dolor quisquam laboriosam enim cum laborum suscipit perferendis adipisci praesentium.</p>
                                                <div class="conversation-item-time">12:30</div>
                                            </div>
                                            <div class="conversation-item-dropdown">
                                                <button type="button" class="conversation-item-dropdown-toggle"><i class="ri-more-2-line"></i></button>
                                                <ul class="conversation-item-dropdown-list">
                                                    <li><a href="#"><i class="ri-share-forward-line"></i> Forward</a></li>
                                                    <li><a href="#"><i class="ri-delete-bin-line"></i> Delete</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li class="conversation-item me">
                                <div class="conversation-item-side">
                                    <img class="conversation-item-image" src="https://images.unsplash.com/photo-1534528741775-53994a69daeb?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OXx8cGVvcGxlfGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60" alt="">
                                </div>
                                <div class="conversation-item-content">
                                    <div class="conversation-item-wrapper">
                                        <div class="conversation-item-box">
                                            <div class="conversation-item-text">
                                                <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Quas, eos, magni temporibus, placeat consectetur nobis incidunt dicta a culpa vel esse. Facilis fugiat possimus eveniet accusamus dignissimos pariatur inventore animi rem vero, eligendi obcaecati fugit quaerat? Officia ex quod eaque maxime ipsam, tempore error laboriosam laborum, magnam ipsum doloremque quas.</p>
                                                <div class="conversation-item-time">12:30</div>
                                            </div>
                                            <div class="conversation-item-dropdown">
                                                <button type="button" class="conversation-item-dropdown-toggle"><i class="ri-more-2-line"></i></button>
                                                <ul class="conversation-item-dropdown-list">
                                                    <li><a href="#"><i class="ri-share-forward-line"></i> Forward</a></li>
                                                    <li><a href="#"><i class="ri-delete-bin-line"></i> Delete</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="conversation-item-wrapper">
                                        <div class="conversation-item-box">
                                            <div class="conversation-item-text">
                                                <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Temporibus debitis odio maiores perferendis ipsa repudiandae amet blanditiis quod. Ullam, dolorum.</p>
                                                <div class="conversation-item-time">12:30</div>
                                            </div>
                                            <div class="conversation-item-dropdown">
                                                <button type="button" class="conversation-item-dropdown-toggle"><i class="ri-more-2-line"></i></button>
                                                <ul class="conversation-item-dropdown-list">
                                                    <li><a href="#"><i class="ri-share-forward-line"></i> Forward</a></li>
                                                    <li><a href="#"><i class="ri-delete-bin-line"></i> Delete</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="conversation-item-wrapper">
                                        <div class="conversation-item-box">
                                            <div class="conversation-item-text">
                                                <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Accusantium blanditiis ea, voluptatum, eveniet at harum minima maxime enim aut non, iure expedita excepturi tempore nostrum quasi natus voluptas dolore ducimus!</p>
                                                <div class="conversation-item-time">12:30</div>
                                            </div>
                                            <div class="conversation-item-dropdown">
                                                <button type="button" class="conversation-item-dropdown-toggle"><i class="ri-more-2-line"></i></button>
                                                <ul class="conversation-item-dropdown-list">
                                                    <li><a href="#"><i class="ri-share-forward-line"></i> Forward</a></li>
                                                    <li><a href="#"><i class="ri-delete-bin-line"></i> Delete</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="conversation-form">
                        <button type="button" class="conversation-form-button"><i class="ri-emotion-line"></i></button>
                        <div class="conversation-form-group">
                            <textarea class="conversation-form-input" rows="1" placeholder="Type here..."></textarea>
                            <button type="button" class="conversation-form-record"><i class="ri-mic-line"></i></button>
                        </div>
                        <button type="button" class="conversation-form-button conversation-form-submit"><i class="ri-send-plane-2-line"></i></button>
                    </div>
                </div>
                <!-- end: Conversation -->
            </div>
            <!-- end: Content -->
        </div>
    </section>
     
    </section>
    <!-- CONTENT -->
  </div>
</template>


<script>
import NavbarOne from "./NavbarOne.vue";
import SidebarMenu from "./SidebarMenu.vue";
import DashboardContent from "./DashboardContent.vue";

export default {
  name: 'App',
  components: {
    NavbarOne,
    SidebarMenu,
    DashboardContent
  },
mounted() {
    // Call the method to set up toggle sidebar functionality
    this.setupToggleSidebar();
  },
  methods: {
    setupToggleSidebar() {
      // Select elements by IDs
     
      const searchButton = document.querySelector('#content nav form .form-input button');
      const searchButtonIcon = document.querySelector('#content nav form .form-input button .bx');
      const searchForm = document.querySelector('#content nav form');
      const switchMode = document.getElementById('switch-mode');

      // Add event listeners
     

      if (searchButton) {
        searchButton.addEventListener('click', (e) => {
          if (window.innerWidth < 576 && searchForm) {
            e.preventDefault();
            searchForm.classList.toggle('show');
            if (searchForm.classList.contains('show')) {
              searchButtonIcon.classList.replace('bx-search', 'bx-x');
            } else {
              searchButtonIcon.classList.replace('bx-x', 'bx-search');
            }
          }
        });
      }

      // Handle dark mode switch
      if (switchMode) {
        switchMode.addEventListener('change', () => {
          document.body.classList.toggle('dark');
        });
      }

      // Handle sidebar menu items
      const allSideMenu = document.querySelectorAll('#sidebar .side-menu.top li a');
      if (allSideMenu) {
        allSideMenu.forEach(item => {
          const li = item.parentElement;
          item.addEventListener('click', () => {
            allSideMenu.forEach(i => {
              i.parentElement.classList.remove('active');
            });
            li.classList.add('active');
          });
        });
      }
    }
  }
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap');



/* start: Globals */
*, ::before, ::after {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font: inherit;
}

body {
    font-family: 'Inter', sans-serif;
    color: var(--slate-700);
}
/* end: Globals */



/* start: Chat */
.chat-section {
    box-shadow: inset 0 160px 0 0 var(--emerald-500);
    min-height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
    background-color: var(--slate-100);
}
.chat-container {
    max-width: 1360px;
    width: 100%;
    height: 720px;
    box-shadow: 0 8px 24px -4px rgba(0, 0, 0, .1);
    background-color: var(--white);
    position: relative;
}
/* end: Chat */



/* start: Sidebar */
.chat-sidebar {
    width: 64px;
    background-color: var(--slate-100);
    height: 100%;
    display: flex;
    flex-direction: column;
    position: absolute;
    left: 0;
    top: 0;
    z-index: 50;
}
.chat-sidebar-logo {
    font-size: 28px;
    color: var(--emerald-600);
    display: block;
    text-align: center;
    padding: 12px 8px;
    text-decoration: none;
}
.chat-sidebar-menu {
    list-style-type: none;
    display: flex;
    flex-direction: column;
    height: 100%;
    padding: 16px 0;
}
.chat-sidebar-menu > * > a {
    display: block;
    text-align: center;
    padding: 12px 8px;
    font-size: 24px;
    text-decoration: none;
    color: var(--slate-400);
    position: relative;
    transition: color .15s ease-in-out;
}
.chat-sidebar-menu > * > a:hover {
    color: var(--slate-600);
}
.chat-sidebar-menu > .active > a {
    box-shadow: inset 4px 0 0 0 var(--emerald-500);
    color: var(--emerald-600);
    background-color: var(--emerald-100);
}
.chat-sidebar-menu > * > a::before {
    content: attr(data-title);
    position: absolute;
    top: 50%;
    left: calc(100% - 16px);
    border-radius: 4px;
    transform: translateY(-50%);
    font-size: 13px;
    padding: 6px 12px;
    background-color: rgba(0, 0, 0, .6);
    color: var(--white);
    opacity: 0;
    visibility: hidden;
    transition: all .15s ease-in-out;
}
.chat-sidebar-menu > * > a:hover::before {
    left: calc(100% - 8px);
    opacity: 1;
    visibility: visible;
}
.chat-sidebar-profile {
    margin-top: auto;
    position: relative;
}
.chat-sidebar-profile-toggle {
    background-color: transparent;
    border: none;
    outline: transparent;
    width: 40px;
    height: 40px;
    margin: 0 auto;
    display: block;
    cursor: pointer;
}
.chat-sidebar-profile-toggle > img {
    object-fit: cover;
    width: 100%;
    height: 100%;
    border-radius: 50%;
}
.chat-sidebar-profile-dropdown {
    position: absolute;
    bottom: 100%;
    left: 16px;
    background-color: var(--white);
    box-shadow: 0 2px 8px rgba(0, 0, 0, .1);
    list-style-type: none;
    border-radius: 4px;
    padding: 4px 0;
    opacity: 0;
    visibility: hidden;
    transform: scale(.9);
    transform-origin: left bottom;
    transition: all .15s ease-in-out;
}
.chat-sidebar-profile.active .chat-sidebar-profile-dropdown {
    opacity: 1;
    visibility: visible;
    transform: scale(1);
}
.chat-sidebar-profile-dropdown a {
    display: flex;
    align-items: center;
    padding: 8px 12px;
    text-decoration: none;
    color: var(--slate-400);
    font-size: 14px;
}
.chat-sidebar-profile-dropdown a:hover {
    background-color: var(--slate-100);
    color: var(--slate-600);
}
.chat-sidebar-profile-dropdown a:active {
    background-color: var(--slate-200);
}
.chat-sidebar-profile-dropdown a i {
    margin-right: 12px;
    font-size: 17px;
}
/* end: Sidebar */



/* start: Content side */
.chat-content {
    padding-left: 64px;
    height: 100%;
    position: relative;
}
.content-sidebar {
    width: 256px;
    background-color: var(--white);
    display: flex;
    flex-direction: column;
    height: 100%;
    position: absolute;
    top: 0;
    left: 64px;
}
.content-sidebar-title {
    font-size: 20px;
    font-weight: 600;
    padding: 16px;
}
.content-sidebar-form {
    position: relative;
    padding: 0 16px;
}
.content-sidebar-input {
    padding: 8px 16px;
    background-color: var(--slate-100);
    border: 1px solid var(--slate-300);
    outline: none;
    width: 100%;
    border-radius: 4px;
    padding-right: 32px;
    font-size: 14px;
}
.content-sidebar-input:focus {
    border-color: var(--slate-400);
}
.content-sidebar-submit {
    position: absolute;
    top: 50%;
    transform: translateY(-50%);
    right: 32px;
    color: var(--slate-400);
    background-color: transparent;
    outline: transparent;
    border: none;
    cursor: pointer;
    transition: color .15s ease-in-out;
}
.content-sidebar-submit:hover {
    color: var(--slate-600);
}
.content-messages {
    overflow-y: auto;
    height: 100%;
    margin-top: 16px;
}
.content-messages-list {
    list-style-type: none;
    padding: 8px 0;
}
.content-messages-list > * > a {
    display: flex;
    align-items: center;
    text-decoration: none;
    color: var(--slate-700);
    padding: 6px 16px;
}
.content-messages-list > * > a:hover {
    background-color: var(--slate-50);
}
.content-messages-list > .active > a {
    background-color: var(--slate-100);
}
.content-message-title {
    margin-left: 16px;
    margin-right: 16px;
    color: var(--slate-400);
    font-size: 13px;
    font-weight: 500;
    margin-bottom: 2px;
    position: relative;
}
.content-message-title > * {
    position: relative;
    z-index: 1;
    padding: 0 4px 0 0;
    background-color: var(--white);
}
.content-message-title::before {
    content: '';
    position: absolute;
    top: 50%;
    transform: translateY(-50%);
    left: 0;
    width: 100%;
    height: 0;
    border-bottom: 1px solid var(--slate-300);
    z-index: 0;
}
.content-message-image {
    width: 32px;
    height: 32px;
    border-radius: 50%;
    object-fit: cover;
    flex-shrink: 0;
    margin-right: 12px;
}
.content-message-info {
    display: grid;
    margin-right: 12px;
    width: 100%;
}
.content-message-name {
    display: block;
    font-size: 14px;
    font-weight: 500;
    margin-bottom: 2px;
}
.content-message-text {
    font-size: 13px;
    color: var(--slate-400);
    text-overflow: ellipsis;
    overflow: hidden;
    white-space: nowrap;
}
.content-message-more {
    text-align: right;
}
.content-message-unread {
    font-size: 12px;
    font-weight: 500;
    color: var(--white);
    background-color: var(--emerald-500);
    padding: 2px 4px;
    border-radius: 4px;
}
.content-message-time {
    font-size: 12px;
    color: var(--slate-400);
    font-weight: 500;
}
/* end: Content side */



/* start: Conversation */
.conversation {
    background-color: var(--slate-100);
    height: 100%;
    padding-left: 256px;
    display: none;
}
.conversation.active {
    display: flex;
    flex-direction: column;
}
.conversation-top {
    padding: 8px 16px;
    background-color: var(--white);
    display: flex;
    align-items: center;
}
.conversation-back {
    background-color: transparent;
    border: none;
    outline: none;
    width: 32px;
    height: 32px;
    align-items: center;
    justify-content: center;
    font-size: 20px;
    cursor: pointer;
    color: var(--slate-400);
    margin-right: 12px;
    display: none;
}
.conversation-back:hover {
    background-color: var(--slate-100);
    border-radius: 50%;
    color: var(--slate-600);
}
.conversation-back:active {
    background-color: var(--slate-200);
}
.conversation-user {
    display: flex;
    align-items: center;
}
.conversation-user-image {
    width: 40px;
    height: 40px;
    border-radius: 50%;
    object-fit: cover;
    margin-right: 8px;
}
.conversation-user-name {
    font-weight: 500;
    font-size: 17px;
}
.conversation-user-status {
    color: var(--slate-400);
    font-size: 13px;
}
.conversation-user-status::before {
    content: '';
    width: 10px;
    height: 10px;
    background-color: var(--slate-300);
    border-radius: 50%;
    vertical-align: middle;
    display: inline-block;
    margin-right: 4px;
}
.conversation-user-status.online::before {
    background-color: var(--emerald-500);
}
.conversation-buttons {
    display: flex;
    align-items: center;
    margin-left: auto;
}
.conversation-buttons > * {
    width: 36px;
    height: 36px;
    display: flex;
    align-items: center;
    justify-content: center;
    border-radius: 4px;
    font-size: 20px;
    background-color: transparent;
    border: none;
    outline: transparent;
    cursor: pointer;
    color: var(--slate-600);
    margin-left: 4px;
}
.conversation-buttons > :hover {
    background-color: var(--slate-100);
    color: var(--slate-700);
}
.conversation-buttons > :active {
    background-color: var(--slate-200);
}

.conversation-main {
    overflow-y: auto;
    overflow-x: hidden;
    height: 100%;
    padding: 16px;
}
.conversation-wrapper {
    list-style-type: none;
}
.conversation-item {
    display: flex;
    align-items: flex-end;
    flex-direction: row-reverse;
    margin-bottom: 16px;
}
.conversation-item.me {
    flex-direction: row;
}
.conversation-item-side {
    margin-left: 8px;
}
.conversation-item.me .conversation-item-side {
    margin-right: 8px;
}
.conversation-item-image {
    width: 24px;
    height: 24px;
    border-radius: 50%;
    object-fit: cover;
    display: block;
}
.conversation-item-content {
    width: 100%;
}
.conversation-item-wrapper:not(:last-child) {
    margin-bottom: 8px;
}
.conversation-item-box {
    max-width: 720px;
    position: relative;
    margin-left: auto;
}
.conversation-item.me .conversation-item-box {
    margin-left: unset;
}
.conversation-item-text {
    padding: 12px 16px 8px;
    background-color: var(--white);
    box-shadow: 0 2px 12px -2px rgba(0, 0, 0, .1);
    font-size: 14px;
    border-radius: 6px;
    line-height: 1.5;
    margin-left: 32px;
}
.conversation-item.me .conversation-item-text {
    margin-left: unset;
    margin-right: 32px;
}
.conversation-item.me .conversation-item-text {
    background-color: var(--emerald-500);
    box-shadow: 0 2px 12px -2px var(--emerald-500);
    color: rgba(255, 255, 255, .8);
}
.conversation-item-time {
    font-size: 10px;
    color: var(--slate-400);
    display: block;
    text-align: right;
    margin-top: 4px;
    line-height: 1;
}
.conversation-item.me .conversation-item-time {
    color: rgba(255, 255, 255, .7);
}
.conversation-item-dropdown {
    position: absolute;
    top: 0;
    left: 0;
    opacity: 0;
    visibility: hidden;
    transition: all .15s ease-in-out;
}
.conversation-item.me .conversation-item-dropdown {
    left: unset;
    right: 0;
}
.conversation-item-wrapper:hover .conversation-item-dropdown {
    opacity: 1;
    visibility: visible;
}
.conversation-item-dropdown-toggle {
    width: 24px;
    height: 24px;
    display: flex;
    align-items: center;
    justify-content: center;
    border-radius: 4px;
    background-color: var(--white);
    outline: transparent;
    border: 1px solid var(--slate-200);
    cursor: pointer;
    transition: all .15s ease-in-out;
}
.conversation-item-dropdown-toggle:hover {
    background-color: var(--emerald-500);
    color: var(--white);
    box-shadow: 0 2px 12px -2px var(--emerald-500);
}
.conversation-item-dropdown-toggle:active {
    background-color: var(--emerald-600);
}
.conversation-item-dropdown-list {
    position: absolute;
    top: 100%;
    left: 0;
    background-color: var(--white);
    z-index: 10;
    box-shadow: 0 2px 8px rgba(0, 0, 0, .1);
    border-radius: 4px;
    padding: 4px 0;
    list-style-type: none;
    opacity: 0;
    visibility: hidden;
    transform: scale(.9);
    transform-origin: left top;
    transition: all .15s ease-in-out;
}
.conversation-item.me .conversation-item-dropdown-list {
    left: unset;
    right: 0;
}
.conversation-item-dropdown.active .conversation-item-dropdown-list {
    opacity: 1;
    visibility: visible;
    transform: scale(1);
}
.conversation-item-dropdown-list a {
    display: flex;
    align-items: center;
    text-decoration: none;
    color: var(--slate-400);
    font-size: 13px;
    padding: 6px 12px;
}
.conversation-item-dropdown-list a:hover {
    background-color: var(--slate-100);
    color: var(--slate-600);
}
.conversation-item-dropdown-list a:active {
    background-color: var(--slate-200);
}
.conversation-item-dropdown-list a i {
    font-size: 16px;
    margin-right: 8px;
}
.coversation-divider {
    text-align: center;
    font-size: 13px;
    color: var(--slate-400);
    margin-bottom: 16px;
    position: relative;
}
.coversation-divider::before {
    content: '';
    position: absolute;
    top: 50%;
    transform: translateY(-50%);
    left: 0;
    width: 100%;
    height: 0;
    border-bottom: 1px solid var(--slate-300);
}
.coversation-divider span {
    display: inline-block;
    padding: 0 8px;
    background-color: var(--slate-100);
    position: relative;
    z-index: 1;
}

.conversation-form {
    padding: 8px 16px;
    background-color: var(--white);
    display: flex;
    align-items: flex-end;
}
.conversation-form-group {
    width: 100%;
    position: relative;
    margin-left: 16px;
    margin-right: 16px;
}
.conversation-form-input {
    background-color: var(--slate-100);
    border: 1px solid var(--slate-300);
    border-radius: 4px;
    outline: transparent;
    padding: 10px 32px 10px 16px;
    font: inherit;
    font-size: 14px;
    resize: none;
    width: 100%;
    display: block;
    line-height: 1.5;
    max-height: calc(20px + ((14px * 2) * 6));
}
.conversation-form-input:focus {
    border-color: var(--slate-400);
}
.conversation-form-record {
    position: absolute;
    bottom: 8px;
    right: 16px;
    font-size: 20px;
    color: var(--slate-400);
    background-color: transparent;
    border: none;
    outline: transparent;
    cursor: pointer;
}
.conversation-form-record:hover {
    color: var(--slate-600);
}
.conversation-form-button {
    width: 40px;
    height: 40px;
    display: flex;
    align-items: center;
    justify-content: center;
    border-radius: 4px;
    border: none;
    background-color: transparent;
    outline: transparent;
    font-size: 20px;
    color: var(--slate-400);
    cursor: pointer;
    flex-shrink: 0;
}
.conversation-form-button:hover {
    background-color: var(--slate-100);
    color: var(--slate-600);
}
.conversation-form-button:active {
    background-color: var(--slate-200);
    color: var(--slate-600);
}
.conversation-form-submit {
    background-color: var(--emerald-500);
    box-shadow: 0 2px 8px -2px var(--emerald-500);
    color: var(--white);
}
.conversation-form-submit:hover {
    background-color: var(--emerald-600);
    color: var(--white);
}
.conversation-form-submit:active {
    background-color: var(--emerald-700);
    color: var(--white);
}
.conversation-default {
    align-items: center;
    justify-content: center;
    padding: 16px;
    padding-left: calc(256px + 16px);
    color: var(--slate-400);
}
.conversation-default i {
    font-size: 32px;
}
.conversation-default p {
    margin-top: 16px;
}
/* end: Conversation */



/* start: Breakpoints */
@media screen and (max-width: 1600px) {
    .chat-container {
        max-width: unset;
        height: 100vh;
    }
}

@media screen and (max-width: 767px) {
    .chat-sidebar {
        top: unset;
        bottom: 0;
        width: 100%;
        height: 48px;
    }
    .chat-sidebar-logo {
        display: none;
    }
    .chat-sidebar-menu {
        flex-direction: row;
        padding: 0;
    }
    .chat-sidebar-menu > *,
    .chat-sidebar-menu > * > a {
        width: 100%;
        height: 100%;
    }
    .chat-sidebar-menu > * > a {
        padding: 8px;
    }
    .chat-sidebar-menu > .active > a {
        box-shadow: inset 0 4px 0 0 var(--emerald-500);
    }
    .chat-sidebar-profile {
        margin-top: 0;
        display: flex;
        align-items: center;
    }
    .chat-sidebar-profile-toggle {
        width: 32px;
        height: 32px;
    }
    .chat-sidebar-profile-dropdown {
        left: unset;
        right: 16px;
    }

    .conversation,
    .chat-content {
        padding-left: unset;
    }
    .content-sidebar {
        left: unset;
        z-index: 10;
        width: 100%;
    }
    .chat-sidebar-menu > * > a::before {
        left: 50%;
        transform: translateX(-50%);
        bottom: 100%;
        top: unset;
    }
    .chat-sidebar-menu > * > a:hover::before {
        bottom: calc(100% + 8px);
        left: 50%;
    }

    .chat-content {
        position: relative;
        height: calc(100% - 48px);
    }
    .conversation.active {
        position: relative;
        z-index: 20;
    }
    .conversation-back {
        display: flex;
    }
    .conversation-default.active {
        display: none;
        padding: 16px;
    }
}
</style>
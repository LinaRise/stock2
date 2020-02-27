<template>
    <v-container>
        <v-dialog v-model="billDialog" max-width="500px">
            <template v-slot:activator="{ on }">
                <v-btn color="primary" dark class="mb-2" v-on="on">Добавить накладную</v-btn>
            </template>
            <v-card>
                <v-card-title>
                    <span class="headline">Новая накладная</span>
                </v-card-title>

                <v-card-text>
                    <v-container>
                        <v-row>
                            <v-col cols="12" sm="6" md="4">
                                <v-select
                                        v-model="editedBill.stock"
                                        :items="stockAddresses"
                                        label="Адрес склада"
                                />
                            </v-col>
                        </v-row>
                        <v-row>
                            <v-col cols="12" sm="6" md="4">
                                <v-select
                                        v-model="editedBill.provider"
                                        :items="providerAddresses"
                                        label="Адрес поставщика"
                                />
                            </v-col>
                        </v-row>
                    </v-container>
                </v-card-text>

                <v-card-actions>
                    <v-spacer/>
                    <v-btn color="orange darken-1" text @click="billClose">Cancel</v-btn>
                    <v-btn color="orange darken-1" text @click="billSave">Save</v-btn>
                </v-card-actions>
            </v-card>
        </v-dialog>

        <v-dialog v-model="deleteDialog" max-width="500px">
            <template v-slot:activator="{ on }">
                <v-btn color="primary" dark class="mb-2" v-on="on">Удалить накладную</v-btn>
            </template>
            <v-card>
                <v-card-title>
                    <span class="headline">Удалить накладную</span>
                </v-card-title>

                <v-card-text>
                    <v-container>
                        <v-row>
                            <v-col>
                                <v-select
                                        @change="delSelected"
                                        v-model="deletionId"
                                        :items="billsId"
                                        label="Id накладной"
                                />
                            </v-col>
                        </v-row>
                        <v-row v-if="deletionId !== -1">
                            <v-col cols="12">
                                Адрес склада: <span>{{ billToDelete.stock.address }}</span><br>
                                Адрес поставщика: <span>{{ billToDelete.provider.address }}</span>
                            </v-col>
                        </v-row>
                    </v-container>
                </v-card-text>

                <v-card-actions>
                    <v-spacer/>
                    <v-btn color="orange darken-1" text @click="deleteClose">Cancel</v-btn>
                    <v-btn color="orange darken-1" text @click="deleteSave">Save</v-btn>
                </v-card-actions>
            </v-card>
        </v-dialog>

        <v-select
                :items="billsId"
                @change="idSelected"
                v-model="selectedId"
                label="Выберите Id накладной"
        />
        <div v-if="selectedId !== -1">
            Накладная #{{selectedBill.id}}<br>
            Адрес склада: {{selectedBill.stock.address}}<br>
            Адрес поставщика: {{selectedBill.provider.address}}<br>
        </div>
        <v-data-table
                v-if="selectedId !== -1"
                :headers="billHeaders"
                :items="billProducts"
                sort-by="id"
                class="elevation-1"
        >
            <template v-slot:top>
                <v-toolbar flat color="white">
                    <v-spacer/>
                    <v-dialog v-model="productDialog" max-width="500px">
                        <template v-slot:activator="{ on }">
                            <v-btn color="primary" dark class="mb-2" v-on="on">Добавить товар</v-btn>
                        </template>
                        <v-card>
                            <v-card-title>
                                <span class="headline">{{ productFormTitle }}</span>
                            </v-card-title>

                            <v-card-text>
                                <v-container>
                                    <v-row>
                                        <v-col cols="12" sm="6" md="4">
                                            <v-select
                                                    v-model="editedProduct.product"
                                                    :items="productNames"
                                                    label="Название товара"
                                            />
                                        </v-col>
                                    </v-row>
                                    <v-row>
                                        <v-col cols="12" sm="6" md="4">
                                            <v-text-field v-model="editedProduct.count"
                                                          label="Количество"/>
                                        </v-col>
                                    </v-row>
                                </v-container>
                            </v-card-text>

                            <v-card-actions>
                                <v-spacer/>
                                <v-btn color="orange darken-1" text @click="productClose">Cancel</v-btn>
                                <v-btn color="orange darken-1" text @click="productSave">Save</v-btn>
                            </v-card-actions>
                        </v-card>
                    </v-dialog>
                </v-toolbar>
            </template>
            <template v-slot:item.action="{ item }">
                <v-icon
                        small
                        class="mr-2"
                        @click="editProduct(item)"
                >
                    edit
                </v-icon>
                <v-icon
                        small
                        @click="deleteProduct(item)"
                >
                    delete
                </v-icon>
            </template>
        </v-data-table>
    </v-container>
</template>

<script>
    export default {
        name: "OutcomePage",
        data() {
            return {
                billsId: [],
                selectedId: -1,
                selectedBill: {},
                billProducts: [],
                productDialog: false,
                billHeaders: [
                    {
                        text: 'Id товара',
                        value: 'product.id'
                    },
                    {
                        text: 'Название',
                        value: 'product.title'
                    },
                    {
                        text: 'Цена',
                        value: 'product.price'
                    },
                    {
                        text: 'Количество',
                        value: 'count'
                    },
                    {
                        text: 'Единица измерения',
                        value: 'product.measurement.measure'
                    },
                    {
                        text: 'Действия',
                        value: 'action'
                    }
                ],
                stockAddresses: [],
                providerAddresses: [],
                measurements: [],
                productNames: [],
                editedProductIndex: -1,
                editedProduct: {
                    title: '',
                    price: 0
                },
                defaultProduct: {
                    title: '',
                    price: 0
                },
                billDialog: false,
                editedBill: {
                    stock: {},
                    provider: {}
                },
                defaultBill: {
                    stock: {},
                    provider: {}
                },
                deletionId: -1,
                deleteDialog: false,
                billToDelete: {
                    stock: {
                        address: ''
                    },
                    provider: {
                        address: ''
                    }
                }
            }
        },
        computed: {
            productFormTitle() {
                return this.editedProductIndex === -1 ? 'Новый товар' : 'Редактировать';
            },
        },
        watch: {
            productDialog(val) {
                val || this.productClose()
            },
        },
        methods: {
            idSelected() {
                this.billProducts = [];
                this.$resource("/outcomeBill{/id}").get({id: this.selectedId}).then(result =>
                    result.json().then(data => {
                        this.selectedBill = data;
                        data.outcomeStrings.forEach(element => {
                            this.billProducts.push(element);
                        });
                    })
                );
            },
            productClose() {
                this.productDialog = false;
                this.editedProductIndex = -1;
                this.editedProduct = Object.assign({}, this.defaultProduct);
            },
            productSave() {
                const outcomeString = {
                    count: this.editedProduct.count,
                    product: this.editedProduct.product,
                    outcome_bill: this.selectedBill
                };
                if (this.editedProductIndex > -1) {
                    Object.assign(this.billProducts[this.editedProductIndex], this.editedProduct);
                    this.$resource("/outcomeStrings{/id}").update({id: this.editedProduct.id}, outcomeString);
                } else {
                    this.$resource("/outcomeStrings").save(outcomeString).then(result =>
                        result.json().then(data => this.billProducts.push(data))
                    );
                }
                this.productClose();
            },
            editProduct(item) {
                this.editedProductIndex = this.billProducts.indexOf(item);
                this.editedProduct = Object.assign({}, item);
                this.productDialog = true;
            },
            deleteProduct(item) {
                const index = this.billProducts.indexOf(item);
                let isDeleted = confirm('Удалить товар?') && this.billProducts.splice(index, 1);
                if (isDeleted) {
                    this.$resource("/outcomeStrings{/id}").remove(item.id);
                }
            },
            billClose() {
                this.billDialog = false;
                this.editedBill = Object.assign({}, this.defaultBill);
            },
            billSave() {
                this.$resource("/outcomeBill").save(this.editedBill).then(result =>
                    result.json().then(data => this.billsId.push(data.id))
                );

                this.billClose();
            },
            delSelected() {
                this.$resource("/outcomeBill{/id}").get({id: this.deletionId}).then(result =>
                    result.json().then(data => {
                        this.billToDelete = data;
                    })
                );
            },
            deleteClose() {
                this.deletionId = -1;
                this.billToDelete = {};
                this.deleteDialog = false;
            },
            deleteSave() {
                this.$resource("/outcomeBill{/id}").remove({id: this.deletionId}).then(result => {
                    if (result.ok) {
                        const index = this.billsId.indexOf(this.deletionId);
                        this.billsId.splice(index, 1);
                    }
                });
                this.deleteClose();
            }
        },
        created() {
            this.$resource("/outcomeBill").get().then(result =>
                result.json().then(data => {
                    data.forEach(element => {
                        this.billsId.push(element.id);
                    });
                })
            );
            this.$resource("/product").get().then(result =>
                result.json().then(data => {
                    data.forEach(element => {
                        this.productNames.push({text: element.title, value: element});
                    });
                })
            );
            this.$resource("/provider").get().then(result =>
                result.json().then(data => {
                    data.forEach(element => {
                        this.providerAddresses.push({text: element.address, value: element});
                    });
                })
            );
            this.$resource("/stock").get().then(result =>
                result.json().then(data => {
                    data.forEach(element => {
                        this.stockAddresses.push({text: element.address, value: element});
                    });
                })
            );
        }
    }
</script>

<style scoped>

</style>